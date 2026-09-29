package com.maxarchm.launcher.platform.icons

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.BitmapShader
import android.graphics.Shader
import android.graphics.drawable.AdaptiveIconDrawable
import android.graphics.drawable.Drawable
import android.os.UserHandle
import androidx.core.graphics.createBitmap
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.drawable.toDrawable
import com.maxarchm.launcher.R

internal sealed interface LauncherIconShape {
    data object SystemAdaptive : LauncherIconShape
}

internal data class LauncherIconAppearance(
    val shape: LauncherIconShape = LauncherIconShape.SystemAdaptive,
)

internal fun interface LauncherIconRenderer {
    fun render(
        source: Drawable,
        user: UserHandle,
        appearance: LauncherIconAppearance,
    ): Drawable
}

internal class SystemLauncherIconRenderer(
    context: Context,
) : LauncherIconRenderer {
    private val applicationContext = context.applicationContext
    private val packageManager = applicationContext.packageManager
    private val resources = applicationContext.resources
    private val iconSizePixels = resources.getDimensionPixelSize(
        R.dimen.drawer_application_icon_size,
    )

    override fun render(
        source: Drawable,
        user: UserHandle,
        appearance: LauncherIconAppearance,
    ): Drawable {
        val normalizedBitmap = when (appearance.shape) {
            LauncherIconShape.SystemAdaptive -> renderSystemAdaptiveIcon(source)
        }
        val normalizedDrawable = normalizedBitmap.toDrawable(resources)

        return packageManager.getUserBadgedIcon(normalizedDrawable, user)
    }

    private fun renderSystemAdaptiveIcon(source: Drawable): Bitmap {
        val sourceBitmap = source.toBitmap(
            width = iconSizePixels,
            height = iconSizePixels,
            config = Bitmap.Config.ARGB_8888,
        )

        val result = createBitmap(
            iconSizePixels,
            iconSizePixels,
        )
        val resultCanvas = Canvas(result)
        val maskSource = AdaptiveIconDrawable(Color.BLACK.toDrawable(), null).apply {
            bounds = Rect(0, 0, iconSizePixels, iconSizePixels)
        }
        val maskPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG).apply {
            shader = BitmapShader(sourceBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        }
        resultCanvas.drawPath(maskSource.iconMask, maskPaint)
        return result
    }
}
