# Iteration 37: Home Edit Mode Interaction

> Applicable version contract: [1.8.0 delivery](delivery.md). This contract defines scope only and does not authorize implementation, commits, pushes, tags, or releases.

## Objective

Deliver the revised Home edit-mode interaction, including module titles and their relationship to existing editing actions, without introducing module collapse.

## Product and version references

- Product-contract baseline: `0e6ac891f26f0d7ea5d4e483d4d0916a99de23b6`
- Applicable product documents: [Home behavior](../../product/surfaces/home.md), [Home presentation](../../product/presentation/home.md), [Navigation](../../product/navigation.md), [Home bottom app bar](../../product/features/home-bottom-app-bar.md)
- Applicable version contract: [1.8.0 delivery](delivery.md)
- All linked product documents are read at product-contract baseline `0e6ac891f26f0d7ea5d4e483d4d0916a99de23b6`.

## Observable outcome

The author can enter, use, and leave Home edit mode through the contracted targets, sees module titles in their defined role, and can complete existing edit actions without ambiguous or duplicate targets.

## Included work

- Module title presentation and edit-mode entry relationship.
- Edit-mode entry from the bound basic-information quick action, exit, Back, gesture, target, and restoration behavior covered by the current contract.
- Negative boundaries: ordinary blank Home space, the time/date region, favorite content, and Loading/Error/Retry regions do not create an additional edit-mode entry.
- Integration with the bottom app bar boundary from Iteration 36.
- Bilingual resources, navigation, presentation, wireframes, and focused tests.

## Excluded work

- Module collapse or expansion, collapsed-list persistence, and title-triggered folding.
- New favorite placement rules or Flow layout.
- New edit-mode capabilities not defined by the current product documents.

## Technical change areas

Home edit-mode state and coordination, module headers, navigation, accessibility semantics, resources, and tests.

## Dependencies and sequence

This iteration follows Iteration 36 and establishes the interaction boundary used by Iteration 38.

## Migration and compatibility impact

Existing Home content and favorite state remain unchanged. Missing presentation state follows current contract defaults.

## Security, privacy, permission, and licensing impact

No new permission, network, account, or external service is introduced.

## Risks and unresolved decisions

Module titles must not imply that the module can collapse. Edit-mode targets must remain distinct from bottom-app-bar targets and ordinary content gestures.

## Acceptance criteria

- Module titles match their defined presentation role and do not imply collapse.
- The bound basic-information entry reaches edit mode, while ordinary blank space, time/date, favorite, Loading, Error, and Retry regions do not enter edit mode.
- Enter, exit, Back, and restoration behavior matches the contract.
- Existing edit actions remain reachable and unambiguous.
- No collapsed-list state or persistence is introduced.

## Validation requirements

Validate the bound basic-information entry, negative entry boundaries, edit-mode exit, Back, process recreation, module-title presentation, bottom-app-bar interaction, accessibility traversal, and ordinary Home gestures on the primary device.

## Related decisions and technical assessments

- [Home behavior](../../product/surfaces/home.md)
- [Home presentation](../../product/presentation/home.md)
