# Iteration 32: Quick Actions and Screen Locking

> Applicable version contract: [1.7.0 delivery](delivery.md). This contract defines the authorized delivery boundary only. It does not own execution state, evidence, commits, or results, and it does not by itself authorize production implementation, a commit, a push, a tag, or any release action.

## Objective

Deliver the accepted quick-actions contract exactly as defined: the two configurable Home basic-information quick-action slots with their bindings, persistence, and backup inclusion; the Quick action settings sub-page with its slot rows, always-visible screen-lock service state row, and anchored single-choice popup; the generalized screen-lock wording replacing double-tap lock; the removal of the standalone Double-tap-to-lock Settings item; and the purpose-limited accessibility service moved into the mainline so the bound Screen lock gesture exists in every build type.

## Product and version references

- Product-contract baseline: `da22d3d1c4c3e22105a8d6f96256c1e6ffe626d4` — the current mainline head, which contains the accepted quick-actions and screen-locking contracts (`4d3151d25412a65bbf649056d4d784a58371d80c`), the Home default-launcher prompt contract (`7698498624d1d45efc940eb249a722423b593f68`), and the product rename.
- Applicable product documents:
  - [Quick actions behavior](../../product/features/quick-actions.md)
  - [Screen locking behavior](../../product/features/double-tap-lock.md)
  - [Privacy and data handling](../../product/features/privacy.md)
  - [Home behavior](../../product/surfaces/home.md), basic-information quick-action sections
  - [Settings behavior](../../product/surfaces/settings.md), Quick action settings sub-page
  - [Settings presentation](../../product/presentation/settings.md)
  - [Navigation](../../product/navigation.md)
  - [Product foundation](../../requirements/product-foundation.md)
- Applicable version contract: `delivery.md`

## Observable outcome

On the primary device, a fresh configuration presents both quick-action slots as No action, and no basic-information gesture triggers any action. Selecting a slot opens the anchored single-choice popup offering No action, Edit mode, and Screen lock with no cross-slot validation. Binding Edit mode makes the bound gesture enter Home edit mode; binding Screen lock while the accessibility service is off enters the disclosed authorization flow without changing the saved binding, and once the service is enabled the bound gesture locks the screen, with the contracted failure toast when a lock request fails. The Quick action settings sub-page always shows the screen-lock service state row; Back returns from it; process restoration does not restore it. The Settings list no longer contains a standalone Double-tap-to-lock item. A backup file written after this iteration contains the bindings and restores into a fresh installation; backups written before this iteration still import without bindings under the directional compatibility rule.

## Included work

- The two-slot quick-action binding model with the three options, the No action defaults, and the absence of cross-slot validation.
- Slot gesture recognition on the eligible basic-information blank space per the contract: recognition thresholds and cancellation paths follow the platform behavior the contract defines, and a slot bound to No action performs no action.
- Persistence of the bindings in local settings state and their inclusion in the manual backup file contents and the local data enumeration.
- The Quick action settings primary item in Settings and the Quick action settings sub-page: its slot rows, the always-visible screen-lock service state row, the anchored single-choice popup, Back semantics, and the rule that process restoration does not restore the page.
- The screen-lock authorization flow entered when Screen lock is bound while the service is off, without letting that flow change the saved binding.
- Generalized screen locking: the accessibility authorization entry moved to the Quick action settings page, the purpose-limited service boundary and disclosure flow unchanged.
- Removal of the standalone Double-tap-to-lock Settings item and its explanation sheet entry point from the Settings list.
- The accessibility service moved from the debug-only source set into the mainline source set with its manifest declaration and configuration, and the application graph wiring the real controller in every build type under the unchanged fail-closed request behavior.
- The ADR-0004 rewrite to the binding-driven trigger and the mainline integration it now records.
- Privacy alignment: the privacy statement, accessibility disclosure title and body, and the screen-lock explanation strings updated to the bound-gesture and screen-lock wording of the current privacy contract, in English and Simplified Chinese.
- Localized English and Simplified Chinese strings for all new or changed user-visible text with complete name parity.
- Focused test sources covering slot resolution and defaults, popup selection, binding persistence and backup parity, the authorization flow, the service-state row, and the removal of the old Settings item.

## Excluded work

- The Home default-launcher prompt, the shared text glow, and the application-size tapering sliders, which belong to Iteration 33.
- Any landscape behavior or orientation change.
- The distribution-boundary product-contract change and every release-operations item, which belong to Iteration 34.
- The `1.7.0` version identifier update (`versionName`/`versionCode`), which remains a version-level closure concern unless a later authorized amendment assigns it here.
- Any change to the purpose-limited accessibility service boundary: no content reading, no event observation, and the fail-closed single-action request remain exactly as contracted.

## Technical change areas

- Home basic-information gesture handling: slot resolution replacing the hard-coded double-tap and long-press behavior.
- Settings store: the new binding fields with versioned persistence, and the backup serialization extension.
- Settings UI: the new primary item, sub-page, slot rows, state row, and popup; removal of the old item and its sheet.
- Navigation: the new sub-page destination and its Back and restoration rules.
- Accessibility integration: the service and its manifest/configuration moved from `app/src/debug` to the mainline source set; the application graph controller selection for all build types.
- Privacy resources: disclosure and statement strings in both languages.
- ADR-0004 rewritten to record the binding-driven trigger and mainline integration.
- Tests: focused local and instrumentation sources for the behaviors above.

## Dependencies and sequence

This iteration is the first in the 1.7.0 sequence and depends only on the accepted contracts at the recorded baseline. Its store, backup, and strings areas overlap Iteration 33 only in shared resources, and it precedes Iteration 34's operational work because the formal release artifact requires a screen-lock capability that exists in release builds. The implementation line must contain the recorded baseline before production implementation proceeds.

## Migration and compatibility impact

- The backup schema extends with the bindings section. Older backups without bindings import under the directional schema-compatibility rule and resolve both slots to the contracted No action default; newer schema versions fail as contracted.
- Existing local configurations without binding fields resolve to the No action defaults under the contract default rule; no prior double-tap-lock on/off preference is mapped, because the generalized contract removes that setting.
- The service move changes release builds: a release installation can now appear in the system accessibility list once the user enters the authorization flow. No upgrade-time behavior change occurs before that point.

## Security, privacy, permission, and licensing impact

- The accessibility service in mainline builds carries its `BIND_ACCESSIBILITY_SERVICE` permission into release builds; its purpose-limited boundary (only the lock-screen global action, no content reading, fail-closed) is unchanged, and the disclosure flow is unchanged.
- The privacy statement and accessibility disclosure copy must match the shipped behavior exactly; any material divergence found during implementation stops the work for author direction.
- No new networking, account, or external service is introduced.

## Risks and unresolved decisions

- Replacing the hard-coded gestures must not regress edit-mode entry, the lock failure toast, or the existing instrumentation coverage; the old tests must be reworked, not merely deleted.
- The service mainline move makes the accessibility-related lint surface and the system accessibility list change shape for release builds; the lint baseline must be refreshed within the iteration if the move introduces entries.
- Backup parity tests must prove that bindings survive a backup → restore round trip and that old backups remain importable.
- The ADR rewrite is an architecture-record change owned by the author; the iteration implements the already-ruled direction and does not re-decide it.

## Acceptance criteria

- A fresh configuration shows both slots as No action, and no basic-information gesture triggers any action.
- Each slot's popup offers exactly No action, Edit mode, and Screen lock; selections persist across recreation and restart; cross-slot duplicates are accepted without validation.
- A slot bound to Edit mode enters Home edit mode through its bound gesture; the other slot's behavior is unaffected.
- Binding Screen lock while the service is off enters the authorization flow and leaves the saved binding unchanged; with the service enabled, the bound gesture locks the screen, and a failed lock request presents the contracted toast without retry.
- The Quick action settings sub-page shows the always-visible service state row, returns on Back, and is not restored after process death.
- The Settings list contains no standalone Double-tap-to-lock item, and the old explanation sheet is reachable only through the contracted entry.
- Bindings appear in the backup file and survive a backup → restore round trip into a fresh installation; pre-extension backups import without bindings.
- The privacy statement and accessibility disclosure match the shipped bound-gesture and screen-lock behavior in both languages.
- All new or changed user-visible strings exist in English and Simplified Chinese with complete name parity.
- No regression of ordinary Home interaction, Settings navigation, backup/restore of favorites and display settings, or Drawer behavior.

## Validation requirements

Recommended scenarios unless explicitly promoted:

- Device journeys on the primary physical device: fresh-state defaults, popup selection for both slots, each binding's gesture behavior, the authorization flow with the service off, service enablement and the bound lock gesture, and the failure toast.
- Settings sub-page journeys: state row accuracy across service on/off, Back, process death and restoration.
- Backup round trips including bindings, and import of a pre-extension backup.
- Release-build verification that the bound Screen lock gesture exists and functions in a release APK, coordinated with Iteration 34's artifact work.
- String parity between English and Simplified Chinese resources.
- Regression of ordinary Home, Settings, Drawer, and backup/restore journeys.

## Related decisions and technical assessments

- [Quick actions behavior](../../product/features/quick-actions.md) — the owning behavior contract.
- [Screen locking behavior](../../product/features/double-tap-lock.md) — the generalized locking contract and service boundary.
- [Privacy and data handling](../../product/features/privacy.md) — the disclosure and statement copy this iteration aligns.
- [ADR-0004: purpose-limited accessibility service](../../decisions/0004-purpose-limited-accessibility-service-for-double-tap-lock.md) — the decision record rewritten by this iteration to the binding-driven trigger and mainline integration.
