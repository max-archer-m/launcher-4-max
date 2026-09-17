# Iteration 33: Home and Drawer Contract Completion

> Applicable version contract: [1.7.0 delivery](delivery.md). This contract defines the authorized delivery boundary only. It does not own execution state, evidence, commits, or results, and it does not by itself authorize production implementation, a commit, a push, a tag, or any release action.

## Objective

Deliver the three remaining accepted-contract surfaces on Home and Drawer exactly as defined: the dismissible Home default-launcher prompt, the shared text glow replacing the glyph shadow on its contracted texts, and the application-size block's two three-stop tapering sliders — with one author-device calibration pass that fixes the deliberately deferred visual values and records them back into their presentation contracts.

## Product and version references

- Product-contract baseline: `da22d3d1c4c3e22105a8d6f96256c1e6ffe626d4` — the current mainline head, which contains the accepted default-launcher prompt contract (`7698498624d1d45efc940eb249a722423b593f68`), the shared text-glow contract, and the application-size tapering-slider contract.
- Applicable product documents:
  - [Home behavior](../../product/surfaces/home.md), default-launcher prompt section
  - [Home presentation](../../product/presentation/home.md), prompt presentation and glow assignment
  - [Drawer presentation](../../product/presentation/drawer.md), glow assignment
  - [Style settings panel presentation](../../product/presentation/style-settings-panel.md), application-size tapering sliders
  - [Design foundations](../../product/design-foundations.md), shared text glow
  - [Settings behavior](../../product/surfaces/settings.md), default-home destination shared with the prompt
  - [Privacy and data handling](../../product/features/privacy.md), prompt disclosure
- Applicable version contract: `delivery.md`

## Observable outcome

On the primary device, while Launcher4Max is not the default launcher, Home shows the dismissible prompt between the basic-information region and the favorite main list with its three localized labels, the contracted fill, corners, boundary, and outer inset; it is evaluated once per foreground entry, never appears mid-session after a foreground entry without it, disappears immediately when the app becomes the default, is suppressed for the remainder of the local day after its Dismiss control is used, is hidden throughout edit mode, and its tap routes to the same system destination as the Settings default-home entry. Application names on the Home main list, the edit-dock instruction text, and Drawer application names and search-field hint text render the shared text glow with no glyph shadow on those texts, while the Home basic-information text keeps its contracted glyph shadow. The application-size block presents the two three-stop tapering sliders with the calibrated visual values, snapping stops at Large, Medium, and Small, the dual-color track split at the thumb, and per-slider accessibility labels, tier names, and range actions.

## Included work

- The Home default-launcher prompt: bounded region placement, once-per-foreground-entry visibility evaluation, immediate removal on becoming default, no reminder-attempt limit, same-day suppression after Dismiss, dismissal date stored as durable presentation state outside the backup file, edit-mode hiding, single layout change absorbing removal and restoration, the `Settings.ACTION_HOME_SETTINGS` routing shared with the Settings default-home entry, the non-interactive arrow hint beside the separate dismiss target, and the contracted `72dp` minimum height, `darkSurfaceBaseColor` fill, `12dp` corners, shared `12%` boundary, `8dp` outer inset, and opaque-surface text treatment.
- The shared text glow as the non-interactive capsule backdrop layer on the contracted texts — Home main-list application names, edit-dock instruction text, Drawer application names, and Drawer search-field hint text — replacing, never stacking with, the glyph shadow on those texts, while the Home basic-information text keeps its glyph shadow per the author's ruling.
- The calibrated glow delivery values (implementation technique, fade curve, capsule height, horizontal extent) written back into the design-foundations contract once accepted on the author's device.
- The application-size block's two three-stop tapering sliders as one custom control: the right-triangle track silhouette decreasing left to right, snapping stops at the left end, midpoint, and right end, the bar-shaped thumb whose position alone expresses the tier with no text indicator, the `primaryTextColor` left-of-thumb track and thumb with the `secondaryTextColor` remainder, the `16dp` gap and equal division of the remaining line width, and per-slider localized labels, current tier name, and standard localized range actions each moving one tier.
- The calibrated slider delivery values (end heights, bar height, width, and corner treatment) written back into the style-settings-panel contract once accepted on the author's device.
- Slider disabled behavior per the host contract: a disabled slider reports unavailable and does not change the tier.
- Localized English and Simplified Chinese strings for the prompt's three labels and any new or changed user-visible text with complete name parity.
- Focused test sources covering prompt visibility and suppression state, the glow layering on the contracted texts, and the slider's stop mapping, tier selection, colors, and accessibility semantics.

## Excluded work

- Quick actions, screen locking, and the accessibility service move, which belong to Iteration 32.
- The distribution-boundary change and every release-operations item, which belong to Iteration 34.
- Any landscape behavior or orientation change.
- Glow or slider application beyond the contracted texts and the application-size block; no other surface adopts the glow in this iteration.
- Any change to the application-size tier model itself — the three tiers, their defaults, persistence, and backup contents remain as delivered in 1.6.0.

## Technical change areas

- Home layout: the bounded prompt region between the basic-information region and the favorite main list, its visibility state, and edit-mode hiding.
- Presentation state: the durable local-day dismissal date stored outside the backup file.
- Text rendering: the glow backdrop layer on the contracted texts and the shadow removal on exactly those texts; the shared technique serves Home and Drawer.
- Style settings panel: the custom tapering-slider control replacing the current application-size control.
- Privacy resources: the prompt-related disclosure strings if the contract's privacy wording requires resource updates.
- Design-foundations and style-settings-panel contracts: calibration write-back through the authorized amendment path.
- Tests: focused local and instrumentation sources for the behaviors above.

## Dependencies and sequence

This iteration is independent of Iteration 32 in behavior and code areas, with shared-resource overlap only; by the version's serial default it follows Iteration 32. Its implementation line must contain the recorded baseline before production implementation proceeds. The calibration pass requires author-device participation and precedes the final acceptance of the glow and slider work.

## Migration and compatibility impact

- The dismissal date is new presentation state outside the backup file: a fresh install or restored backup starts with no suppression, per contract.
- No settings-store schema change is required; the application-size tiers persist exactly as delivered.
- Removing the glyph shadow from the contracted texts is a pure presentation change with no state impact.

## Security, privacy, permission, and licensing impact

- No new permission, networking, account, or external service is introduced.
- The prompt's visibility rule and dismissal state fall inside the disclosed presentation state per the privacy contract; the privacy wording is aligned in the same change if the prompt disclosure requires resource updates.
- The glow and sliders are local presentation behavior.

## Risks and unresolved decisions

- The glow technique, fade curve, capsule height, and horizontal extent are deliberately `To be decided`; implementation must propose calibratable candidates, and only author-device acceptance finalizes them. If calibration stalls, the glow work can be accepted in two stages (structure first, values on acceptance) without expanding the boundary.
- The tapering slider's end heights, bar height, width, and corner treatment share the same calibration dependency.
- The parked Drawer automation cluster centers on slider drag injection; automated coverage for the new custom slider may hit the same limitation, so device acceptance carries the interaction evidence and automated tests focus on mapping, colors, and accessibility semantics.
- The prompt must never appear mid-session after a foreground entry without it, including across process death within the same local day, which requires careful distinction between durable dismissal state and per-session evaluation.
- Replacing the glyph shadow with the glow must not reintroduce the ribbon-width or text-clipping regressions previously fixed on the favorite ribbon.

## Acceptance criteria

- The prompt shows exactly when the app is not the default launcher, matches the contracted geometry and text treatment, and its three labels exist in both languages.
- Prompt visibility evaluates once per foreground entry, never inserts later in the same session, and removes immediately on becoming default.
- Dismiss suppresses the prompt for the remainder of the local day, the dismissal date persists across restart, and becoming default records no dismissal.
- The prompt routes to the same system destination as the Settings default-home entry, the arrow hint is non-interactive, and the prompt is hidden throughout edit mode with one layout change absorbing removal and restoration.
- The contracted texts render the shared text glow with no glyph shadow; the Home basic-information text keeps its glyph shadow; no other text changes treatment.
- The application-size block presents the two tapering sliders with the calibrated values; each slider snaps at the three stops, splits its track colors at the thumb, exposes its localized label, tier name, and range actions, and a disabled slider changes nothing.
- The calibrated values are recorded back into the design-foundations and style-settings-panel contracts through the authorized amendment path.
- All new or changed user-visible strings exist in English and Simplified Chinese with complete name parity.
- No regression of ordinary Home interaction, edit mode, favorite editing, Drawer search and launching, or the remaining style-panel settings.

## Validation requirements

Recommended scenarios unless explicitly promoted:

- Device journeys on the primary physical device: prompt appearance and geometry, dismissal and same-day suppression across restart, becoming default, edit-mode hiding, and prompt routing.
- Calibration sessions with the author: glow candidates on the contracted texts and slider candidates across the three tiers, with accepted values recorded.
- Glow rendering on both Home and Drawer texts, including background-opacity extremes from the Drawer background slider.
- Slider journeys: tier changes on both sliders, persistence across restart, disabled behavior, and accessibility announcements.
- String parity between English and Simplified Chinese resources.
- Regression of ordinary Home, edit mode, Drawer, and style-panel journeys.

## Related decisions and technical assessments

- [Home behavior](../../product/surfaces/home.md) and [Home presentation](../../product/presentation/home.md) — the owning prompt contract and its presentation values.
- [Design foundations](../../product/design-foundations.md) — the shared text-glow contract whose deferred values this iteration calibrates.
- [Style settings panel presentation](../../product/presentation/style-settings-panel.md) — the tapering-slider contract whose deferred values this iteration calibrates.
- [Product decision and scope-change governance](../../product-decisions.md) — the amendment path for the calibration write-back.
