# Launcher4Max

> Semantic source: English. Simplified Chinese counterpart: [README.zh-CN.md](README.zh-CN.md).

A calm, intentional Android home-screen launcher designed to help users reach the applications and device information they need with minimal distraction.

## Product direction

Launcher4Max is intended to act as an Android device's default home-screen application. It starts with the author's everyday needs and may later serve a broader global audience through English and Simplified Chinese experiences.

The product prioritizes direct access, restrained defaults, user control, and privacy-conscious design. Advertising, recommendation feeds, and engagement-maximizing patterns are outside the confirmed product boundary.

See the [project overview](overview.md) for confirmed intent, boundaries, and unresolved scope. A [Simplified Chinese counterpart](overview.zh-CN.md) is also available.

## Requirements

- Android 12 (API 31) or later.
- An ordinary Android phone. Launcher4Max presents in portrait orientation only; landscape, foldable, tablet, desktop-mode, and external-display layouts are not supported.
- English or Simplified Chinese. Launcher4Max follows the system language and falls back to English.

## Install

Public releases are distributed as Android APK files attached to this repository's Releases. Until the first release is published, build the app yourself with the [development guide](docs/development.md).

1. Install the APK. Because it does not come from an application store, Android first asks you to allow installs from this source.
2. Open Launcher4Max once.
3. Make it your default home app: select Launcher4Max as the default home app in Android settings. The exact path varies by device; on many devices it is **Apps → Default apps → Home app**. While Launcher4Max is not the default, Home also shows a dismissible prompt, and the Settings page has a **Default home application** entry that opens the same system destination.
4. To go back, select your previous launcher in the same system setting. Uninstalling Launcher4Max or clearing its app data removes its locally stored data.

## Your data

- Launcher4Max keeps its data on your device. There is no account, advertising, analytics, crash-report upload, cloud service, or Launcher4Max-operated server, and core Home, Drawer, launching, and Settings behavior works without a network connection.
- Favorites, Drawer display settings, and quick-action bindings are stored locally on the device.
- Settings offers a manual local backup and restore. Back up writes one JSON file to a location you choose through the system document picker, and Restore reads a file you select after your explicit confirmation. The file stays under your control and is never uploaded. There is no automatic, scheduled, or cloud backup.
- Uninstalling Launcher4Max or clearing its app data in Android settings removes its locally stored data. The current product provides no recovery afterwards other than a backup file you made yourself.
- The optional screen-lock capability uses a purpose-limited Android accessibility service. It requests one system lock action when you perform the Home gesture you bound to it. It does not read screen or window content, observe activity in other applications, collect accessibility events, or send or share data. It stays inactive until you bind a gesture to it and enable the service in Android accessibility settings, and you can disable it at any time without losing the other Launcher features.
- Read the full [Privacy and data handling](docs/product/features/privacy.md) statement.

## Documentation

- [Project overview](overview.md)
- [Simplified Chinese project overview](overview.zh-CN.md)
- [Privacy and data handling](docs/product/features/privacy.md)
- [Documentation map and governance](docs/documentation.md)
- [Development guide](docs/development.md)
- [Validation guide](docs/validation.md)
- [Product foundation requirements](docs/requirements/product-foundation.md)
- [Version, artifact, and release governance](docs/release.md)
- [Completed delivery records, currently 1.0.0 through 1.6.0](docs/documentation.md#current-authoritative-documents)
- [Version delivery documents](docs/versions/version-delivery-format.md)
- [Iteration record format](docs/iterations/iteration-record-format.md)
- [Agent instructions](AGENTS.md)
- [Simplified Chinese agent instructions](AGENTS.zh-CN.md)
- [License](LICENSE)

## Feedback

Questions and bug reports are welcome on the [GitHub Issues page](https://github.com/max-archer-m/launcher-4-max/issues).

## License

Licensed under the [Apache License 2.0](LICENSE). Third-party components and their licenses are listed in [Third-party notices](THIRD-PARTY-NOTICES.md).
