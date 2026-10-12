# Home Bottom App Bar

> Public semantic source: English. Chinese counterpart: [home-bottom-app-bar.zh-CN.md](home-bottom-app-bar.zh-CN.md). Exact visual values belong to the [Home presentation specification](../presentation/home.md#home-bottom-app-bar). The Settings entry belongs to [Settings behavior](../surfaces/settings.md).

## Purpose

The Home bottom app bar is one favorite position at the bottom of Home. It is not a favorite module, not a second favorite list, and not the removed edit dock. A favorite placed here is still a favorite. The bar decides only where that favorite is shown.

One stable launchable identity is favorited once across the whole of Home. It cannot occupy both the bar and a favorite module. Primary, cloned, and work-profile entries remain distinct identities.

The accepted Settings entry and page title are `Home bottom app bar` in English and `主页底部常驻应用栏` in Simplified Chinese. The Chinese word for a standing bar names the feature. It does not mean the bar can only use the fixed presentation. The bar shows no application names. Accessibility still announces each application name.

## Settings

- Settings places one primary entry directly below `Icon shape` and above the Data entries. It belongs to the same Launcher-settings grouping and opens its own page. It does not share a page with Icon shape.
- The page title is `Home bottom app bar`. From top to bottom it shows one master switch, one preview, and the remaining settings. The master switch is the only control that turns the feature on or off. It defaults to off.
- While the switch is off, Home shows no bar, no collapsed edge, and no reserved height. Membership, the fixed-or-semi-hidden choice, and the icon size remain saved. The settings below the preview use the shared disabled treatment and reject input. The preview stays visible and does not accept changes.
- While the switch is on and the bar has no favorite, ordinary Home still shows no bar and reserves no height. Edit mode is the exception defined below.
- Turning the switch on defaults the presentation to semi-hidden. The other settings are whether the bar is fixed, and the icon size. Fixed means the bar stays at full height. Not fixed means semi-hidden. Icon size uses the existing Large, Medium, and Small icon tiers. There is no separate maximum-count setting and no membership editor. Adding and removing happen only in Home edit mode. Reordering can also begin from a fully presented favorite in normal Home, as defined by [one-shot operation](../surfaces/home.md#one-shot-operation).
- The preview shows the bottom row without names on one opaque built-in image. It does not sample the current wallpaper. It does not decide capacity. Home's available width does.
- Every settings change applies immediately and persists locally. The page has no separate confirm action.

## Capacity and order

- The bar is one horizontal row ordered from the physical left. It does not wrap and does not scroll inside itself.
- Capacity is the number of whole icons that fit in the current Home safe width after the bar's own side insets and the gap between icons. A partial icon does not count. The count is not stored. Changing width recalculates it.
- When the saved membership no longer fits the selected icon tier, that tier cannot be selected. The bar presents the largest tier that still fits every saved favorite and remembers the tier the user selected. When the width again fits that tier, the bar returns to it. The bar does not shrink an icon silently and does not delete the last favorites.
- Switching between fixed and semi-hidden changes presentation only. Membership, order, and icon size stay the same.

## Home presentation states

- A disabled favorite keeps its place, remains saved, and gives the ordinary unavailable feedback. Selecting it does not launch it. Enabling it again restores it in place.
- A favorite is removed only after a successful refresh confirms permanent disappearance. Later favorites close the gap in their saved order. An uncertain read or a failed refresh does not delete or hide it.
- Ordinary launch uses Home's existing surface-wide rapid-activation window. The default-Launcher prompt, the basic-information quick actions, and the upward Home-to-Drawer gesture keep their existing ownership. The bar does not appear inside the prompt and does not take over those gestures.
- The collapsed bar is the only Home-to-Drawer exception: a tap or a short upward drag that begins on it expands the bar. It does not launch an application and does not start the Drawer transition. A collapsed bar cannot start one-shot operation. A downward drag on Home content still scrolls the favorite main list. It does not expand or collapse the bar.

## Semi-hidden and fixed

- Semi-hidden does not use a separate reveal control. While collapsed, the bar is clipped to the top `24dp` of its full height. Icons stay vertically centered in that full height and are not recentered inside the `24dp`. The favorite main list uses the remaining height. The collapsed bar uses `80%` opacity.
- The whole collapsed `24dp` is the expand target. A tap or a short upward drag expands it. The visible tops of the icons do not launch applications.
- While expanded, the bar uses its full height and full opacity. The favorite main list becomes shorter as the height changes and keeps its logical scroll position. Selecting empty Home space, or dragging downward on the bar, collapses it. System Back collapses an expanded semi-hidden bar before it handles any other Back result.
- Fixed presentation always uses the full height and full opacity. It is not clipped. The favorite main list is shorter by that height. The list keeps the ordinary module spacing above the bar. That spacing is not part of capacity.
- Edit mode shows a semi-hidden bar expanded. Leaving edit mode collapses it again. A fixed bar stays full height.
- Opening and closing use the shared short-duration property animation. When the system requests reduced motion, the bar changes height and opacity without that animation.
- The bar uses one opaque white background at `12%` of `primaryTextColor`. It does not use a dark surface, wallpaper sampling, or blur. Icons on that background do not use the Home glyph shadow.

## Edit mode

- While the feature is on, edit mode shows the bar, including when it has no favorite. With no favorite it shows only the add control. One-shot operation may temporarily expand a collapsed bar, or temporarily show an empty bar while the feature is on, without entering edit mode. Both return to their previous presentation when that operation ends. A release on a full bar is invalid. A Drawer drag-to-favorite uses the same temporary destinations.
- A favorite on the bar uses the same edit treatment as a favorite in a module: a remove control, reordering, and movement between the bar and favorite modules. Selecting it does not launch it, and long-pressing it does not open the application action sheet.
- The remove control unfavorites the application. It does not merely take the application off the bar while leaving it favorited. Undo uses the existing favorite-removal Snackbar and restores the application to its former place on the bar when that place still fits. The bar is not a module and has no whole-module unfavorite action.
- Movement uses the ordinary favorite insertion rules. The bar is a valid favorite destination. The add control is not an insertion destination. During the height animation, destination resolution uses the bar's current height.
- While the bar is below capacity, edit mode shows one add control after the last favorite. The control opens the existing Drawer favorite multi-selection with the bar as its captured destination. The selection cannot exceed the number of remaining places captured when the mode opens. A later width change does not raise or lower that count. An identity that is already favorited stays unavailable. Confirming appends the selected identities to the bar in selection order and makes them favorites. Cancelling changes nothing.

## Backup

- The manual backup includes whether the bar is on, whether it is fixed, its selected icon size, and the ordered favorite identities placed on the bar. The calculated capacity is not stored.
- A missing bar section restores the bar to off with no favorites placed on it. Favorites that the backup places in modules stay in those modules.
