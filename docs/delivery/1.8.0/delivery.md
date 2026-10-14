# Launcher4Max 1.8.0 Delivery

> Semantic source: English. Chinese counterpart: [delivery.zh-CN.md](delivery.zh-CN.md).
>
> This record defines the planned delivery boundary for 1.8.0. It does not authorize production implementation, commits, pushes, tags, or releases.

## Version intent

`1.8.0` consolidates the accepted product updates accumulated after the 1.7.0 public release. It improves icon-shape customization and Home structure, editing, placement, and loading behavior through five independently reviewable iterations. The already completed Drawer search-result bug fix in `a19eba4` is retained as prior work and is not selected as an iteration in this version.

## Delivery level

`Author daily-use baseline`, as defined by [release governance](../../release.md). This version is intended to be installed and accepted by the author on the primary device. A future public artifact, tag, or GitHub Release is outside this version unless separately authorized.

The version identity will be allocated at version closure. No `versionName` or `versionCode` is authorized by this planning record.

## Product references

- [Product overview](../../../overview.md)
- [Product foundation](../../requirements/product-foundation.md)
- [Home behavior](../../product/surfaces/home.md)
- [Drawer behavior](../../product/surfaces/drawer.md)
- [Settings behavior](../../product/surfaces/settings.md)
- [Application action sheet](../../product/surfaces/app-action-sheet.md)
- [Home bottom app bar](../../product/features/home-bottom-app-bar.md)
- [Icon shape](../../product/features/icon-shape.md)
- [Quick actions](../../product/features/quick-actions.md)
- [Home presentation](../../product/presentation/home.md)
- [Drawer presentation](../../product/presentation/drawer.md)
- [Settings presentation](../../product/presentation/settings.md)
- [Navigation](../../product/navigation.md)
- [Validation guide](../../validation.md)

## Included scope and user journey

The author can configure the contracted icon shape and see the result consistently in Home and Drawer. The author can use the Home bottom app bar and the revised Home edit-mode interaction, place favorites through the accepted placement rules, and use the resulting Flow or ribbon layout. Home loading, refresh, restoration, and integration issues discovered within these selected contracts are resolved in the final closure iteration without adding new product capability.

## Exclusions

- Module list collapse and expansion, collapsed-list state, collapsed-list persistence, and related interaction. This remains outside 1.8.0 until a complete product definition is accepted.
- Landscape, foldable-device adaptation, desktop shortcuts, and X4Max naming governance.
- The completed Drawer search-result action fix from `a19eba4`, which is prior work rather than an included iteration.
- New product capabilities discovered during closure; they require a new scope and destination.
- Public release artifact, GitHub Release, APK upload, and repository publication.

## Technical approach and risks

The five iterations run serially because Home layout, editing, placement, and loading share state and presentation surfaces. Each implementation line must contain the accepted product baseline recorded below before production implementation. The final iteration may correct only already-defined behavior and must return newly proposed capability to a separately authorized scope.

Primary risks are interaction overlap between the bottom app bar and edit mode, preserving favorite placement and layout invariants across existing module arrangements, icon-shape consistency across OEM-rendered application icons, and separating loading fixes from new product behavior.

## Included iterations

| Iteration | Status | Updated | Basis |
| --- | --- | --- | --- |
| [Iteration 35: Icon Shape Customization](iteration-35-icon-shape-customization.md) | `Planned` | 2026-10-14 | The current product contract contains the icon-shape settings and rendering scope selected for the first 1.8.0 capability iteration. |
| [Iteration 36: Home Bottom App Bar](iteration-36-home-bottom-app-bar.md) | `Planned` | 2026-10-14 | The author identified the bottom app bar as an independent iteration. |
| [Iteration 37: Home Edit Mode Interaction](iteration-37-home-edit-mode-interaction.md) | `Planned` | 2026-10-14 | The author identified module titles as part of the Home edit-mode interaction change. |
| [Iteration 38: Home Favorite Placement and Layout](iteration-38-home-favorite-placement-layout.md) | `Planned` | 2026-10-14 | The accepted Home placement and layout updates form an independently reviewable placement journey. |
| [Iteration 39: Home Loading and Closure](iteration-39-home-loading-closure.md) | `Planned` | 2026-10-14 | The author requested a final iteration for Home loading and small defined-scope issues. |

## Iteration evidence and results

### Iteration 35: Icon Shape Customization

[Contract](iteration-35-icon-shape-customization.md). Status: `Planned`. No implementation evidence exists yet. Follow-up owner: project author. Final author decision: not applicable yet.

### Iteration 36: Home Bottom App Bar

[Contract](iteration-36-home-bottom-app-bar.md). Status: `Planned`. No implementation evidence exists yet. Follow-up owner: project author. Final author decision: not applicable yet.

### Iteration 37: Home Edit Mode Interaction

[Contract](iteration-37-home-edit-mode-interaction.md). Status: `Planned`. No implementation evidence exists yet. Follow-up owner: project author. Final author decision: not applicable yet.

### Iteration 38: Home Favorite Placement and Layout

[Contract](iteration-38-home-favorite-placement-layout.md). Status: `Planned`. No implementation evidence exists yet. Follow-up owner: project author. Final author decision: not applicable yet.

### Iteration 39: Home Loading and Closure

[Contract](iteration-39-home-loading-closure.md). Status: `Planned`. No implementation evidence exists yet. Follow-up owner: project author. Final author decision: not applicable yet.

## Dependencies and sequence

Iteration 35 and Iteration 36 may be implemented and validated independently after the baseline is accepted; Iteration 36 must include the icon-shape integration for the bottom app bar. Iteration 37 depends on the layout and interaction boundary established by Iteration 36. Iteration 38 depends on the edit-mode interaction rules from Iteration 37. Iteration 39 is limited to regressions directly caused by Iterations 35–38 and depends on their integrated result. This sequence does not bind work to a branch, terminal, or contributor.

## Validation

The mandatory environment is the author's primary physical device. Each iteration requires author acceptance of its selected journey, with focused automated checks recommended for state, serialization, navigation, layout, and regression behavior. Gradle execution remains author-controlled. Unperformed checks must be recorded as `Not run`, `Unavailable`, or `Unknown`.

## Artifact and release requirements

This version uses the `Author daily-use baseline` gates. The accepted APK must record its application identity, version identifiers, source commit, signing category, installation result, known gaps, and primary-device acceptance. Formal release signing, artifact retention, tag, GitHub Release, and publication are not promoted gates for this version.

## Known limitations and legacy issues

- Broader OEM, API, locale, and device coverage remains unknown until performed.
- The parked Drawer slider test cluster remains a known limitation of regression signal.
- Module collapse and expansion remain intentionally outside this version.

## Completion criteria

- All five included iterations are `Completed` with author acceptance.
- The selected product contracts and implementation have no unresolved material mismatch.
- The primary-device journeys for icon shape, bottom app bar, edit mode, favorite placement, and Home loading are accepted.
- Version identifiers, source commit, signing category, known gaps, and validation evidence are recorded.
- The implementation and all applicable 1.8.0 delivery documentation are committed and synchronized to the author-designated shared Git history.

## Completion result

No final result exists. This version is in planning as of 2026-10-14.
