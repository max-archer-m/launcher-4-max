package com.maxarchm.launcher

import android.content.ComponentName
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import com.maxarchm.launcher.ui.drawer.DrawerDisplaySettings

class SettingsBackupRestoreCoordinatorTest {
    @Test
    fun successfulRestoreReplacesFavoritesAndDisplaySettings() = runBlocking {
        val favorites = FakeFavoritesAccess(initial = aggregateWithIdentity(serial = 1))
        val settings = FakeSettingsAccess()
        val bindings = FakeBindingsAccess()
        val coordinator = SettingsBackupRestoreCoordinator(
            favorites = favorites,
            settings = settings,
            bindings = bindings,
        )
        val backup = SettingsBackupState(
            aggregate = aggregateWithIdentity(serial = 2),
            settings = DrawerDisplaySettings(
                backgroundOpacity = 100,
            ),
            bindings = QuickActionBindings(doubleTap = QuickAction.ScreenLock),
        )

        val succeeded = coordinator.restore(backup)

        assertTrue(succeeded)
        assertEquals(backup.aggregate, favorites.aggregate)
        assertEquals(backup.settings, settings.settings)
        assertEquals(backup.bindings, bindings.bindings)
    }

    @Test
    fun failedSettingsRestoreRollsFavoritesBackToPreviousState() = runBlocking {
        val previous = aggregateWithIdentity(serial = 1)
        val favorites = FakeFavoritesAccess(initial = previous)
        val settings = FakeSettingsAccess()
        settings.restoreFails = true
        val coordinator = SettingsBackupRestoreCoordinator(
            favorites = favorites,
            settings = settings,
            bindings = FakeBindingsAccess(),
        )
        val backup = SettingsBackupState(
            aggregate = aggregateWithIdentity(serial = 2),
            settings = DrawerDisplaySettings(
                backgroundOpacity = 100,
            ),
        )

        val succeeded = coordinator.restore(backup)

        assertFalse(succeeded)
        assertEquals(previous, favorites.aggregate)
        assertEquals(
            listOf(backup.aggregate, previous),
            favorites.restoreCalls,
        )
        assertTrue(settings.restoreCalls.isNotEmpty())
    }

    @Test
    fun restoreWithoutReadableFavoriteStateChangesNothing() = runBlocking {
        val favorites = FakeFavoritesAccess(initial = null)
        val settings = FakeSettingsAccess()
        val coordinator = SettingsBackupRestoreCoordinator(
            favorites = favorites,
            settings = settings,
            bindings = FakeBindingsAccess(),
        )
        val backup = SettingsBackupState(
            aggregate = aggregateWithIdentity(serial = 2),
            settings = DrawerDisplaySettings(),
        )

        val succeeded = coordinator.restore(backup)

        assertFalse(succeeded)
        assertTrue(favorites.restoreCalls.isEmpty())
        assertTrue(settings.restoreCalls.isEmpty())
    }

    @Test
    fun restoreWithoutReadableDisplaySettingsChangesNothing() = runBlocking {
        val favorites = FakeFavoritesAccess(null)
        val settings = FakeSettingsAccess(initial = null)
        val coordinator = SettingsBackupRestoreCoordinator(
            favorites = favorites,
            settings = settings,
            bindings = FakeBindingsAccess(),
        )
        val backup = SettingsBackupState(
            aggregate = aggregateWithIdentity(serial = 2),
            settings = DrawerDisplaySettings(),
        )

        val succeeded = coordinator.restore(backup)

        assertFalse(succeeded)
        assertTrue(favorites.restoreCalls.isEmpty())
        assertTrue(settings.restoreCalls.isEmpty())
    }

    private fun aggregateWithIdentity(serial: Long) = OrderedFavoriteAggregate(
        modules = listOf(
            OrderedFavoriteModule(
                id = "vertical-list-1",
                type = OrderedFavoriteModuleType.Vertical,
                identities = listOf(
                    LaunchableIdentity(
                        serial,
                        ComponentName("com.example", "Main"),
                    ),
                ),
            ),
        ),
    )

    private class FakeFavoritesAccess(
        initial: OrderedFavoriteAggregate?,
    ) : BackupFavoritesAccess {
        var aggregate: OrderedFavoriteAggregate? = initial
        var restoreFails = false
        val restoreCalls = mutableListOf<OrderedFavoriteAggregate>()

        override fun currentOrderedAggregate(): OrderedFavoriteAggregate? = aggregate

        override suspend fun restoreAggregate(
            aggregate: OrderedFavoriteAggregate,
        ): Boolean {
            restoreCalls.add(aggregate)
            if (restoreFails) return false
            this.aggregate = aggregate
            return true
        }
    }

    private class FakeSettingsAccess(
        initial: DrawerDisplaySettings? = DrawerDisplaySettings(),
    ) : BackupSettingsAccess {
        var settings: DrawerDisplaySettings? = initial
        var restoreFails = false
        val restoreCalls = mutableListOf<DrawerDisplaySettings>()

        override fun currentSettings(): DrawerDisplaySettings? = settings

        override suspend fun restoreSettings(settings: DrawerDisplaySettings): Boolean {
            restoreCalls.add(settings)
            if (restoreFails) return false
            this.settings = settings
            return true
        }
    }

    private class FakeBindingsAccess(
        initial: QuickActionBindings? = QuickActionBindings(),
    ) : BackupBindingsAccess {
        var bindings: QuickActionBindings? = initial
        var restoreFails = false
        val restoreCalls = mutableListOf<QuickActionBindings>()

        override fun currentBindings(): QuickActionBindings? = bindings

        override suspend fun restoreBindings(bindings: QuickActionBindings): Boolean {
            restoreCalls.add(bindings)
            if (restoreFails) return false
            this.bindings = bindings
            return true
        }
    }
}
