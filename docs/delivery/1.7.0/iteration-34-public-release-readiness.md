# Iteration 34: Public Release Readiness

> Applicable version contract: [1.7.0 delivery](delivery.md). This contract defines the authorized delivery boundary only. It does not own execution state, evidence, commits, or results, and it does not by itself authorize production implementation, a commit, a push, a tag, or any release action.

## Objective

Bring the project to the state where the `Formal release artifact` gates of release governance can be satisfied for the first public distribution: the authorized product-contract change that records the public-GitHub distribution boundary and the primary-device performance expectation, the operational release decisions that release governance leaves to this project, the stale repository-URL fix, the dependency and license inventory, and the public-facing repository presentation.

## Product and version references

- Product-contract baseline: `da22d3d1c4c3e22105a8d6f96256c1e6ffe626d4` — the current mainline head at planning time. This iteration's product-contract stage will produce a later accepted baseline; when the author accepts it, this contract records a material amendment with the new full 40-character commit ID before dependent operational work proceeds.
- Applicable product documents:
  - [Product overview](../../../overview.md), distribution boundary
  - [Product foundation](../../requirements/product-foundation.md), performance expectation record
  - [Release governance](../../release.md), remaining implementation decisions and formal-artifact gates
  - [Privacy and data handling](../../product/features/privacy.md), contact URL
  - [Development guide](../../development.md), environment record
- Applicable version contract: `delivery.md`

## Observable outcome

The product overview records the public-GitHub-only distribution boundary, and the product foundation records the performance expectation as primary-device acceptance of the core journeys with no numeric thresholds. The privacy contact resource points to the current repository. Release governance's remaining-decision list is fully decided and recorded: the APK directory and retention policy beneath the shared context, the release-keystore custody with its two independent encrypted backups, the authoritative build, signing, digest, install, and validation commands, the tag naming convention, the observability disposition, and the distribution channel. The repository presents a public-facing README with installation instructions and screenshots, and a dependency and license inventory exists with its disposition recorded.

## Included work

- The product-contract stage, executed on a product contract line and subject to author acceptance before the operational stage: the distribution-boundary change in the product overview (public distribution through the GitHub repository replaces the author-daily-use-only boundary) and the performance-expectation record in the product foundation (the author's primary device runs the accepted core journeys; no numeric performance thresholds are pursued), each with its Chinese counterpart.
- The privacy contact URL resource updated from the former repository to the current `launcher-4-max` issues address, in both languages.
- The release-operations decisions, recorded where release governance assigns them: the exact APK directory beneath the shared context with its retention, synchronization, backup, and Git-ignore policy; the release-keystore format, parameters, secure locations, backup procedure, and authorized signing workflow, including the two independent encrypted author-controlled backups required before the first formal artifact; the authoritative build, signing, digest, install, upgrade, and validation commands; the exact tag naming convention; the observability and crash-monitoring disposition for this distribution stage; and the distribution channel and its publication gates.
- The dependency and license inventory with its disposition, including the Third-party License presentation decision for the Settings license row.
- The public repository presentation: README and its Chinese counterpart updated for public readers, installation instructions, screenshots of the accepted surfaces, and the removal of any author-internal-only framing that contradicts the public boundary.
- The formal-artifact traceability record: source commit, signing category, artifact digest, and retention location conventions applied to this version's accepted APK.
- Focused verification that the release APK built under the recorded commands installs, upgrades from the prior version, and runs the accepted core journeys on the primary device.

## Excluded work

- Git tag creation, GitHub Release creation, APK upload, and any publication; these remain separately authorized actions outside every iteration.
- Landscape behavior.
- Quick-actions, screen-locking, prompt, and slider implementation, which belong to Iterations 32 and 33; this iteration only verifies the shipped result through the release artifact.
- Any store distribution, or the specialist legal or store-approval conclusions it would require.
- Code feature work beyond the privacy contact URL resource and any traceability-supporting build configuration the recorded commands require.

## Technical change areas

- Product overview and product foundation: the distribution-boundary and performance-expectation contract changes with Chinese counterparts.
- Privacy resources: the contact URL string in both languages.
- Release governance documents: the recorded operational decisions and command baselines.
- Repository presentation: README, README.zh-CN, installation instructions, screenshots.
- Build configuration: only what the authoritative recorded commands require to be reproducible.
- Licensing: the dependency and license inventory document and the resulting License presentation disposition.

## Dependencies and sequence

This iteration follows Iteration 32, whose mainline accessibility service is a precondition for a release artifact with a functioning bound screen lock. Within the iteration, the product-contract stage precedes the operational stage; the contract records the material amendment with the new baseline once the author accepts the contract change, and the implementation line must contain that new baseline before dependent operational work proceeds. The release-keystore backup requirement must be satisfied before the first formal artifact is packaged, but creating those backups is an author action outside this contract's scope; this iteration records the procedure.

## Migration and compatibility impact

- No application-state schema changes; the release artifact must support the in-place upgrade journey from the prior installed version.
- The distribution-boundary change is documentation-level until the first public artifact is published, which remains a separately authorized action.

## Security, privacy, permission, and licensing impact

- The release-keystore custody rules apply: no private signing material in Git or authoritative documents; completed records store only the certificate SHA-256 fingerprint; the two independent encrypted backups exist before the first formal artifact.
- The dependency and license inventory must cover every shipped dependency, and the resulting disposition must not contradict the privacy statement.
- The public boundary increases exposure of the privacy statement, accessibility disclosure, and repository content; their public-facing accuracy is part of this iteration's acceptance.

## Risks and unresolved decisions

- The operational decisions (APK retention, keystore workflow, commands, tag naming, observability, distribution gates) are author decisions recorded through this iteration; the iteration prepares and drafts them but does not decide them.
- The observability disposition may legitimately be "none for this distribution stage"; recording that decision is still required.
- Screenshot and README work must not disclose private device content or author-internal paths.
- The traceability conventions must reconcile with the existing versioned-identifier discipline; the `versionCode 8` allocation belongs to version closure unless an authorized amendment assigns it here.

## Acceptance criteria

- The product overview and product foundation record the accepted distribution boundary and performance expectation in both languages, and the iteration contract records the amended baseline after acceptance.
- The privacy contact resource points to the current repository in both languages.
- Every remaining-decision item of release governance is decided and recorded in its assigned location, including the keystore custody and two-backup procedure and the authoritative command set.
- The dependency and license inventory exists with a recorded disposition, and the Third-party License presentation decision is recorded.
- The public README, installation instructions, and screenshots present the product accurately for a public reader, with the Chinese counterpart aligned.
- The recorded build, signing, digest, and install commands reproduce the accepted release APK, which installs and upgrades on the primary device and runs the accepted core journeys.
- No private signing material, private device content, or author-internal path appears in any repository-visible document.

## Validation requirements

Recommended scenarios unless explicitly promoted:

- Execute the recorded authoritative commands end to end and verify the digest and traceability records against the produced artifact.
- Install and upgrade the release APK on the primary physical device and run the accepted core journeys, including the bound screen-lock gesture from Iteration 32.
- Review the public README, screenshots, and privacy-facing documents as a public reader would see them.
- Verify the dependency and license inventory against the actual dependency tree.
- Verify that the keystore backup procedure, when executed by the author, satisfies the two-independent-encrypted-backups requirement.

## Related decisions and technical assessments

- [Release governance](../../release.md) — the delivery levels, keystore custody rules, remaining-decision list, and formal-artifact gates this iteration satisfies.
- [Product overview](../../../overview.md) — the distribution boundary changed by this iteration's contract stage.
- [Product foundation](../../requirements/product-foundation.md) — the performance-expectation record this iteration writes.
- [Privacy and data handling](../../product/features/privacy.md) — the public-facing boundary whose resources this iteration corrects.
