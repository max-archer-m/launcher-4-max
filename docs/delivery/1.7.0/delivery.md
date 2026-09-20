# Launcher4Max 1.7.0 Delivery

> Semantic source: English. Chinese counterpart: [delivery.zh-CN.md](delivery.zh-CN.md).
>
> This record defines the planned delivery boundary for 1.7.0. It does not by itself authorize production implementation, a commit, a push, a tag, an artifact movement, a publication, or a release; those actions remain separately authorized.

## Version intent

`1.7.0` closes every known gap between the accepted product contract and the delivered implementation, and brings the project to the readiness state required for its first public release. The author set the version outline on 2026-09-17 in three confirmed parts: completing the unimplemented contract content, completing the pre-release preparation, and keeping any landscape work outside the version until its product definition exists.

The author confirmed the scope rulings on 2026-09-17: the purpose-limited accessibility service moves from the debug-only source set into the mainline as part of the quick-actions iteration; the stale repository URL in the privacy contact resource is fixed as pre-release preparation; and the version's performance expectation is that the author's primary device runs the accepted core journeys, with no additional numeric performance thresholds pursued.

## Delivery level

`Formal release artifact`, as defined by [release governance](../../release.md). The version applies that level's gates plus the explicitly promoted gate that the release keystore satisfies the secure-storage and two-independent-encrypted-backups requirement before the first formal artifact is packaged. A Git tag, GitHub Release, and any outward publication remain separately authorized actions and are not part of version completion.

The application identity is `com.maxarchm.launcher`. The `versionName` is `1.7.0`, and `versionCode` `8` is allocated as the next unused value, to be recorded at the identifier-bump commit when it exists.

## Product references

- [Product overview](../../../overview.md)
- [Product foundation](../../requirements/product-foundation.md)
- [Quick actions behavior](../../product/features/quick-actions.md)
- [Screen locking behavior](../../product/features/double-tap-lock.md)
- [Privacy and data handling](../../product/features/privacy.md)
- [Home behavior](../../product/surfaces/home.md), including the default-launcher prompt section
- [Settings behavior](../../product/surfaces/settings.md), including the Quick action settings sub-page
- [Home presentation](../../product/presentation/home.md)
- [Settings presentation](../../product/presentation/settings.md)
- [Drawer presentation](../../product/presentation/drawer.md)
- [Style settings panel presentation](../../product/presentation/style-settings-panel.md), including the application-size tapering sliders
- [Design foundations](../../product/design-foundations.md), including the shared text glow
- [Navigation](../../product/navigation.md)
- [Release governance](../../release.md)
- [Validation guide](../../validation.md)
- [ADR-0004: purpose-limited accessibility service](../../decisions/0004-purpose-limited-accessibility-service-for-double-tap-lock.md)

## Included scope and user journey

In the completed version, the author can bind each of the two Home basic-information quick-action slots to No action, Edit mode, or Screen lock through a dedicated Quick action settings sub-page, with the bindings preserved in the manual backup file; when Screen lock is bound while the accessibility service is off, selecting it enters the disclosed authorization flow without changing the saved binding. The accessibility service exists in every build type under its purpose-limited boundary, so the bound screen-lock gesture works in release builds. The former standalone Double-tap-to-lock Settings item is removed, and the privacy statement and accessibility disclosure speak of the bound gesture and screen locking.

On Home, the author sees a dismissible default-launcher prompt between the basic-information region and the favorite list whenever Launcher4Max is not the default launcher, evaluates its visibility once per foreground entry, and routes its selection to the same system destination as the Settings default-home entry. Application names and the contracted hint texts render the shared text glow in place of the glyph shadow, and the application-size block presents the two three-stop tapering sliders with their calibrated visual values.

The repository holds the operational decisions release governance requires: the APK retention location and policy, the release-keystore custody and backup procedure, the authoritative build, signing, digest, and install commands, the tag naming convention, and the distribution channel, together with a public-facing README, installation instructions, screenshots, and a dependency and license inventory. The performance expectation is recorded as primary-device acceptance of the core journeys.

## Exclusions

- Landscape mode and any orientation behavior beyond the contracted portrait lock, pending a future author product definition.
- Automatic, scheduled, or cloud backup and any upload of user state.
- A Git tag, GitHub Release, APK upload, or any outward publication; these remain separately authorized.
- Any store distribution or the specialist legal, store-approval, or security review conclusions such distribution would require; this version's distribution channel is the public GitHub repository only.
- New third-party License presentation beyond the inventory and disposition that Iteration 34 delivers.

## Technical approach and risks

Iterations 32 and 33 implement already-accepted contracts; development owns implementation details. Iteration 34 begins with an authorized product-contract change (the distribution boundary and the performance-expectation record) before its operational work, and its contract baseline moves through the amendment rule when the author accepts that change.

Primary risks are: the backup schema extension must keep older backups importable under the directional compatibility rule; replacing the hard-coded double-tap and long-press gestures with slot resolution must not regress edit-mode entry or the failure toast; the accessibility service mainline move changes the release manifest and requires the ADR-0004 rewrite to the binding-driven trigger; the text glow and tapering-slider values are deliberately uncalibrated and need author-device calibration before their contracts can be finalized; the parked Drawer test cluster centers on slider drag injection, so custom-slider automated coverage carries that known risk; and the release gates (keystore custody, digests, traceability) are process work that cannot be shortcut by code.

## Included iterations

| Iteration | Status | Updated | Basis |
| --- | --- | --- | --- |
| [Iteration 32: Quick Actions and Screen Locking](iteration-32-quick-actions-screen-locking.md) | `In Progress` | 2026-09-20 | The project author authorized production implementation of the quick-actions contract on 2026-09-20. |
| [Iteration 33: Home and Drawer Contract Completion](iteration-33-home-drawer-contract-completion.md) | `Planned` | 2026-09-17 | The author's 2026-09-17 version outline designates the remaining Home and Drawer contract content as the second iteration. |
| [Iteration 34: Public Release Readiness](iteration-34-public-release-readiness.md) | `Planned` | 2026-09-17 | The author's 2026-09-17 version outline designates pre-release preparation as the third iteration; the author ruled the same day that the stale URL fix and the primary-device performance expectation belong to it. |

## Iteration evidence and results

### Iteration 32

[Contract](iteration-32-quick-actions-screen-locking.md). `In Progress` as of 2026-09-20. The project author authorized production implementation of the configurable quick-actions contract. The first implementation slice persists the two Home blank-space bindings, replaces the hard-coded double-tap lock and long-press edit gestures, adds the Quick action settings page, and includes the bindings in the backup schema. The second implementation slice moves the purpose-limited accessibility service into the mainline source set with its manifest and configuration, wires the real controller in every build type, and rewrites ADR-0004 to the binding-driven trigger. The author reported compile acceptance of both slices. The agent's local checks (`git diff --check`, line-length sweep of added Kotlin) passed; the agent ran no Gradle build or test command (`Not run`). Device journeys remain `Unknown`. Any lint-baseline refresh required by the release-manifest change remains pending an author-run lint.

### Iteration 33

[Contract](iteration-33-home-drawer-contract-completion.md). No evidence exists yet; the iteration is `Planned`.

### Iteration 34

[Contract](iteration-34-public-release-readiness.md). No evidence exists yet; the iteration is `Planned`.

## Dependencies and sequence

Iteration 32 must complete before Iteration 34's operational work: the formal release artifact must contain a screen-lock capability that exists in release builds, which only the mainline accessibility service provides. Iteration 34's product-contract stage precedes its operational stage within the iteration. Iteration 33 is independent of both in code and contracts, with low file overlap; by the author's standing one-line default the three iterations run serially in the recorded order, and this sequence does not bind work to a branch, terminal, contributor, or forecast date.

## Validation

The mandatory version environment is the author-designated primary physical device. Iteration-level validation follows each iteration contract. Version completion additionally requires the `Formal release artifact` gates of release governance: defined compatibility environment, executed validation without unresolved included-path failures, dependency and license disposition, the security and privacy review of the shipped build, stable release-signing custody with its two independent encrypted backups, artifact digest, external retention, and full source-to-artifact traceability. Performance is validated as primary-device acceptance of the core journeys per the author's 2026-09-17 ruling; no numeric thresholds are pursued.

## Artifact and release requirements

The accepted APK must retain `com.maxarchm.launcher`, use accepted `1.7.0`/`versionCode 8` identifiers, be traceable to one source commit and signing category, and support the required upgrade journey from the prior installed version. The release keystore must satisfy the secure-storage and two-independent-encrypted-backups requirement before the first formal artifact is packaged, and no private signing material may enter Git or the authoritative documents. Retained artifacts live outside the repository under the author-designated shared context with SHA-256 verification after copy. Tag creation, GitHub Release creation, and any upload remain separately authorized.

## Known limitations and legacy issues

- Only one physical validation device exists; broader device, API, OEM, and locale coverage remains unknown until performed.
- The parked Drawer automation cluster (slider drag injection and related suites) remains open from the post-1.6.0 restructure; it is not an included-path gate for this version but limits regression signal in that area.
- The text glow and tapering-slider delivery values are `To be decided` until the Iteration 33 calibration is accepted and written back to their presentation contracts.
- Third-party License presentation stays `To be decided` until the Iteration 34 inventory and disposition are accepted.
- Document-picker and OEM presentation variance accepted in earlier versions remains accepted variance.

## Completion criteria

- All included iterations are `Completed` with separately recorded evidence and author acceptance.
- Product contracts, implementation, tests, and delivery evidence have no unresolved material mismatch in the selected scope.
- The `Formal release artifact` gates of release governance are satisfied, including the release-keystore custody and its two independent encrypted backups recorded before the first formal artifact.
- Final identifiers, allocated `versionCode`, source commit, signing category, artifact digest, retention location, known gaps, and tag disposition are recorded accurately.

## Completion result

No final result exists. This version is in planning as of 2026-09-17.
