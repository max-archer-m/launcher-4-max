# Iteration 39: Home Loading and Closure

> Applicable version contract: [1.8.0 delivery](delivery.md). This contract defines scope only and does not authorize implementation, commits, pushes, tags, or releases.

## Objective

Close Home loading, restoration, and integration issues discovered while validating Iterations 35–38, limited to behavior already defined by the accepted product contracts.

## Product and version references

- Product-contract baseline: `0e6ac891f26f0d7ea5d4e483d4d0916a99de23b6`
- Applicable product documents: [Home behavior](../../product/surfaces/home.md), [Home presentation](../../product/presentation/home.md), [Navigation](../../product/navigation.md), [Icon shape](../../product/features/icon-shape.md), [Home bottom app bar](../../product/features/home-bottom-app-bar.md), [Drawer behavior](../../product/surfaces/drawer.md), [Settings behavior](../../product/surfaces/settings.md), [Validation guide](../../validation.md)
- Applicable version contract: [1.8.0 delivery](delivery.md)
- All linked product documents are read at product-contract baseline `0e6ac891f26f0d7ea5d4e483d4d0916a99de23b6`.

## Observable outcome

Home loads, refreshes, returns, and restores its accepted state without a known included-path failure after the preceding iterations are integrated.

## Included work

- Home loading and first-display issues within existing contracts.
- Refresh, return, process recreation, and state-restoration corrections.
- Integration fixes directly caused by Iterations 35–38, only when they are traceable to an existing contract and do not change capability, data model, or interaction boundaries.
- Each included defect must have a reproduction step, expected result, actual result, owning contract clause, source iteration, and regression check.

## Excluded work

- New product capability, module collapse, new gestures, or new layout rules.
- Unassigned legacy issues unrelated to the selected 1.8.0 journeys.
- Landscape, foldable adaptation, desktop shortcuts, or public release work.

## Technical change areas

Home state collection, loading boundaries, restoration, navigation return paths, layout integration, regression tests, and delivery evidence.

## Dependencies and sequence

This is the final iteration and depends on the integrated results of Iterations 35–38. A newly discovered capability must leave this iteration and receive a separate scope.

## Migration and compatibility impact

No new persisted capability is introduced. Existing favorites and settings must survive the corrected loading and restoration paths.

## Security, privacy, permission, and licensing impact

No new permission, network, account, or external service is introduced. No privacy boundary changes are authorized.

## Risks and unresolved decisions

Closure work can silently expand unless every change is traced to an existing contract clause or a regression caused by an included iteration. The author must decide any proposed expansion separately.

## Acceptance criteria

- Home reaches its accepted loaded state without an included-path loading or restoration failure.
- Unreadable persisted state shows the contracted error and Retry behavior; a valid empty state remains distinguishable from failure.
- Refresh failure or uncertain reads do not delete existing favorites and recover to the contracted reliable state.
- Returning from an ordinary launched application does not show an incorrect Home Loading state.
- Refresh, Back, recreation, and restoration preserve the contracted state.
- No new capability or collapse-list behavior is introduced.
- Every included defect has the required traceability and regression evidence, and primary-device acceptance is recorded.

## Validation requirements

Validate fresh launch, repeated foreground entry, refresh, Back, process recreation, unreadable state, Retry, valid empty state, failed refresh, restoration, and return from an ordinary launched application. Validate integrated edit mode, favorite placement, bottom app bar, icon shape, and Drawer return paths only as regression scenarios for defects introduced by Iterations 35–38.

## Related decisions and technical assessments

- [Home behavior](../../product/surfaces/home.md)
- [Home presentation](../../product/presentation/home.md)
- [Validation guide](../../validation.md)
