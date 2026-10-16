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

internal const val OEM_ICON_CLIP = -1
internal val FREEFORM_ICON_CLIP_RANGE = 0..100

/** Clips a square bitmap without changing source artwork or the production appearance model. */
internal fun clipLauncherIcon(source: Bitmap, clip: Int): Bitmap {
    require(source.width == source.height)
    require(clip == OEM_ICON_CLIP || clip in FREEFORM_ICON_CLIP_RANGE)
    val side = source.width
    val result = createBitmap(side, side)
    val canvas = Canvas(result)
    val paint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG).apply {
        shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
    }
    if (clip == OEM_ICON_CLIP) {
        val mask = AdaptiveIconDrawable(Color.BLACK.toDrawable(), null).apply {
            bounds = Rect(0, 0, side, side)
        }
        canvas.drawPath(mask.iconMask, paint)
    } else {
        val radius = clip.toFloat() / FREEFORM_ICON_CLIP_RANGE.last * side / 2f
        canvas.drawRoundRect(0f, 0f, side.toFloat(), side.toFloat(), radius, radius, paint)
    }
    return result
}

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

        return clipLauncherIcon(sourceBitmap, OEM_ICON_CLIP)
    }
}
