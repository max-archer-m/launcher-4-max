# Iteration 35: Icon Shape Customization

> Applicable version contract: [1.8.0 delivery](delivery.md). This contract defines scope only and does not authorize implementation, commits, pushes, tags, or releases.

## Objective

Deliver the accepted icon-shape preference from Settings through persistence to consistent Home and Drawer rendering.

## Product and version references

- Product-contract baseline: `0e6ac891f26f0d7ea5d4e483d4d0916a99de23b6`
- Applicable product documents: [Icon shape](../../product/features/icon-shape.md), [Settings behavior](../../product/surfaces/settings.md), [Settings presentation](../../product/presentation/settings.md), [Home behavior](../../product/surfaces/home.md), [Drawer behavior](../../product/surfaces/drawer.md)
- Applicable version contract: [1.8.0 delivery](delivery.md)
- All linked product documents are read at product-contract baseline `0e6ac891f26f0d7ea5d4e483d4d0916a99de23b6`.

### Accepted preview amendment: 2026-10-16

The author accepted the bounded preview amendment at
`0ebf612e0553385bdce9e794a1f57500bf5feb8a`, supplementing the original baseline
`0e6ac891f26f0d7ea5d4e483d4d0916a99de23b6` to make preview geometry, sample labels,
and accessibility expectations explicit. The objective and primary acceptance outcome remain unchanged.

- Previous boundary: the original icon-shape Settings preview and selection contract at the original baseline.
- Amended boundary: the accepted 64dp preview insets, 16dp row spacing, localized sample labels,
  and row accessibility semantics within the existing preview journey. This adds no new product scope.
- Changed sources at the amendment revision: [Icon shape](https://github.com/max-archer-m/launcher-4-max/blob/0ebf612e0553385bdce9e794a1f57500bf5feb8a/docs/product/features/icon-shape.md),
  [Settings presentation](https://github.com/max-archer-m/launcher-4-max/blob/0ebf612e0553385bdce9e794a1f57500bf5feb8a/docs/product/presentation/settings.md),
  and the [icon-shape settings wireframe](https://github.com/max-archer-m/launcher-4-max/blob/0ebf612e0553385bdce9e794a1f57500bf5feb8a/docs/product/wireframes/icon-shape-settings.txt),
  including their maintained Chinese counterparts where applicable.
- Acceptance and validation include the amended preview geometry, label presentation, and accessibility
  semantics alongside the existing selection, persistence, Home/Drawer, and backup journeys.
  The implementation line must contain the amendment baseline before dependent implementation.
  Other product references retain the original baseline.

## Observable outcome

The author can select the contracted icon shape in Settings, see it applied consistently to eligible application icons in Home and Drawer, and retain the selection across recreation and restart.

## Included work

- Icon-shape Settings entry, choices, labels, and selection behavior.
- Persistence, default behavior, and compatibility with existing settings and backup data.
- Home and Drawer icon rendering through the shared shape contract.
- English and Simplified Chinese resources, navigation, presentation, glossary, privacy, and wireframe alignment.
- Focused tests for selection, persistence, rendering, and accessibility semantics.

## Excluded work

- Custom application artwork, arbitrary per-application shapes, and foldable adaptation.
- Changes to application name placement or Home layout.
- Module collapse and expansion.

## Technical change areas

Settings state and serialization, shared icon rendering, Home and Drawer surfaces, resources, navigation, wireframes, and focused tests.

## Dependencies and sequence

This is the first 1.8.0 iteration. The implementation line must contain the recorded product baseline.

## Migration and compatibility impact

Existing installations use the contracted default when the new preference is absent. Existing backup files remain importable under the current directional compatibility rules.

## Security, privacy, permission, and licensing impact

No new permission, network, account, or external service is introduced. Privacy wording must match the local-only setting.

## Risks and unresolved decisions

OEM application icon masks may expose inconsistent source artwork. The implementation must keep the application shape preference separate from system launcher masking.

## Acceptance criteria

- Settings exposes the contracted icon-shape choices in both languages.
- Selection persists across restart and applies consistently in Home and Drawer.
- Existing settings and backup behavior remain compatible.
- Accessibility labels and focus order remain valid.

## Validation requirements

Validate each shape on the primary device in Home and Drawer, across relevant arrangements, after restart and backup restore. Run focused automated checks where available.

## Related decisions and technical assessments

- [Icon shape contract](../../product/features/icon-shape.md)
- [Settings behavior](../../product/surfaces/settings.md)
