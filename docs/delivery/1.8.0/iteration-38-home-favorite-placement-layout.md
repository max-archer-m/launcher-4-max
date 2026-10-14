# Iteration 38: Home Favorite Placement and Layout

> Applicable version contract: [1.8.0 delivery](delivery.md). This contract defines scope only and does not authorize implementation, commits, pushes, tags, or releases.

## Objective

Deliver the accepted Home favorite-placement journey and its existing Flow or ribbon layout rules without adding collapsed-list behavior.

## Product and version references

- Product-contract baseline: `0e6ac891f26f0d7ea5d4e483d4d0916a99de23b6`
- Applicable product documents: [Home behavior](../../product/surfaces/home.md), [Drawer behavior](../../product/surfaces/drawer.md), [Application action sheet](../../product/surfaces/app-action-sheet.md), [Home presentation](../../product/presentation/home.md), [Drawer presentation](../../product/presentation/drawer.md)
- Applicable version contract: [1.8.0 delivery](delivery.md)
- All linked product documents are read at product-contract baseline `0e6ac891f26f0d7ea5d4e483d4d0916a99de23b6`.

## Observable outcome

The author can place an eligible application through the contracted Home placement journey and sees it inserted into the correct existing module position and layout without an implied collapse feature.

## Included work

- One-shot Home favorite placement and target-position resolution.
- Placement rules across the currently defined Home module arrangements.
- Flow layout, ribbon wrapping or horizontal scrolling, and existing overflow behavior.
- Integration with the edit-mode interaction from Iteration 37.
- Bilingual behavior, presentation, navigation, glossary, wireframe, and focused test alignment.

## Excluded work

- Module collapse and expansion or any collapsed-list target.
- New module types, vertical favorites, desktop shortcuts, or new placement gestures.
- Changes to the Drawer search-result fix already delivered in `a19eba4`.

## Technical change areas

Favorite placement state and coordination, Home layout measurement, module insertion, Drawer/action-sheet handoff, accessibility semantics, resources, and tests.

## Dependencies and sequence

This iteration follows Iteration 37. Its final layout result is consumed by Iteration 39.

## Migration and compatibility impact

Existing favorites remain in their current order and module identity. Placement changes must preserve backup and restore compatibility.

## Security, privacy, permission, and licensing impact

No new permission, network, account, or external service is introduced. Favorite changes remain local and within the existing backup boundary.

## Risks and unresolved decisions

Target resolution must remain deterministic across arrangements and must not confuse an insertion target with a future collapsed-list affordance.

## Acceptance criteria

- Eligible applications are placed at the contract-defined target.
- Existing module order, Flow layout, ribbon wrapping, and scrolling rules remain correct.
- Cancellation and invalid-target paths leave Home in a valid state.
- Favorite persistence and backup/restore remain compatible.
- No collapse state or collapse interaction is introduced.

## Validation requirements

Validate placement from each supported source and target, cancellation, Back, restart, arrangements, overflow, accessibility, and backup restore on the primary device.

## Related decisions and technical assessments

- [Home behavior](../../product/surfaces/home.md)
- [Drawer behavior](../../product/surfaces/drawer.md)
- [Application action sheet](../../product/surfaces/app-action-sheet.md)
