# Third-Party Notices

Launcher4Max is distributed under the [Apache License 2.0](LICENSE). It includes the third-party components listed below. Versions follow [`gradle/libs.versions.toml`](gradle/libs.versions.toml).

## Shipped in the application

| Component | Version | License |
| --- | --- | --- |
| Kotlin Standard Library (`org.jetbrains.kotlin:kotlin-stdlib`) | 2.3.10 | Apache License 2.0 |
| AndroidX Core KTX (`androidx.core:core-ktx`) | 1.18.0 | Apache License 2.0 |
| AndroidX Activity Compose (`androidx.activity:activity-compose`) | 1.13.0 | Apache License 2.0 |
| AndroidX Lifecycle Runtime Compose (`androidx.lifecycle:lifecycle-runtime-compose`) | 2.11.0 | Apache License 2.0 |
| AndroidX Compose UI (`androidx.compose.ui:ui`) | via Compose BOM 2026.06.01 | Apache License 2.0 |
| AndroidX Compose UI Tooling Preview (`androidx.compose.ui:ui-tooling-preview`) | via Compose BOM 2026.06.01 | Apache License 2.0 |
| AndroidX Compose Foundation (`androidx.compose.foundation:foundation`) | via Compose BOM 2026.06.01 | Apache License 2.0 |
| AndroidX Compose Material 3 (`androidx.compose.material3:material3`) | via Compose BOM 2026.06.01 | Apache License 2.0 |

The Apache License 2.0 text that covers these components is included in this repository as [LICENSE](LICENSE).

## Used for development and testing only

These components are not included in a release APK.

| Component | Version | License |
| --- | --- | --- |
| AndroidX Compose UI Tooling (`androidx.compose.ui:ui-tooling`) | via Compose BOM 2026.06.01 | Apache License 2.0 |
| AndroidX Compose UI Test Manifest (`androidx.compose.ui:ui-test-manifest`) | via Compose BOM 2026.06.01 | Apache License 2.0 |
| AndroidX Compose UI Test JUnit4 (`androidx.compose.ui:ui-test-junit4`) | via Compose BOM 2026.06.01 | Apache License 2.0 |
| AndroidX Test Ext JUnit (`androidx.test.ext:junit`) | 1.3.0 | Apache License 2.0 |
| AndroidX Test Espresso Core (`androidx.test.espresso:espresso-core`) | 3.7.0 | Apache License 2.0 |
| JUnit 4 (`junit:junit`) | 4.13.2 | Eclipse Public License 1.0 |

## Scope

This list covers the components Launcher4Max declares in [`gradle/libs.versions.toml`](gradle/libs.versions.toml). Transitive components resolved by the Android build are not enumerated here; the complete shipped set is verified against the resolved dependency graph before a release artifact is published.
