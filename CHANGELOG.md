# Changelog

All notable changes to this project will be documented in this file.

## [1.2.1] - 2026-05-18

### Compatibility
- Migrated the build from `org.jetbrains.intellij` 1.x to `org.jetbrains.intellij.platform` 2.x.
- Updated the Gradle wrapper to `9.5.0` and aligned the plugin build with Java `21` for modern IntelliJ IDEA releases.
- Raised supported IntelliJ IDEA compatibility to `2024.2` through `2026.1`.

### Enhancements
- Replaced internal `HtmlElementDescriptorImpl` checks in attribute descriptor providers with safer `HtmlTag` checks.
- Updated plugin metadata and release notes to match the new platform compatibility range.

### Verification
- Built and verified the plugin successfully against IntelliJ IDEA `2025.1` and `2026.1` platform builds using JetBrains Plugin Verifier.

## [1.2.0] - 2025-11-05

### New Features
- Added support for Thymeleaf Synthetic `<th:block>`
- Added URL completion for th:href and th:action scanning the spring controllers if existing
- 🚀 Thymeleaf Support Plugin v1.2.0
Enhancements for IntelliJ IDEA 2023.1 – 2025.2

This release brings major improvements to Thymeleaf development in IntelliJ IDEA — including full support for `<th:block>`, smart URL and expression completion, and deeper Spring integration.

### New Features
#### 1. Support for `<th:block>` Synthetic Tags
- Added full IDE recognition of Thymeleaf’s non-rendered `<th:block>` tag.
- New contributor and descriptor classes:
- ThymeleafBlockCompletionContributor
- ThymeleafBlockTagDescriptor
- SimpleThymeleafAttributeDescriptor
- ThymeleafBlockInspectionSuppressor
- Enables IntelliJ autocompletion and validation for `<th:block>` elements.

#### 2. Smart URL Completion for th:href and th:action
  - Automatically scans Spring controllers for @GetMapping, @PostMapping, etc.
  - Suggests URL paths directly in Thymeleaf templates:
    - `<a th:href="@{/users}">...</a>`
    - `<form th:action="@{/login}" method="post">...</form>`

##### Implemented in:
  - ControllerMappingInfo
  - ControllerUrlUtil
  - ThymeleafUrlCompletionContributor

#### 3. Spring Model Attribute Discovery
  - Detects @ModelAttribute methods, parameters, and model.addAttribute() calls.
  - Extracts associated model object names and view contexts for smarter completions.
  - Implemented in:
  - ModelAttributeInfo
  - SpringModelAttributeUtil

#### 4. Expression Completion Overhaul
  - Context-aware completion for:
  - ${...} (Variable)
  - *{...} (Selection)
  - #{...} (Message)
  - Auto-inserts correct expression syntax using new insert handlers.
  - Nested property chain detection and caching for performance.

##### Implemented in:
 - ThymeleafExpressionCompletionContributor
 - ThymeleafExpressionInsertHandler
 - AsteriskInsertHandler, DollarSignInsertHandler, HashTagInsertHandler
 - ThymeleafExpressionSuggester

### Enhancements
  - Added missing attributes to autocompletion:
  - th:errors, th:errorclass, th:field
  - Expanded attribute descriptions and tooltips.
  - Improved internal caching for PSI model inspection.
  - Simplified Gradle build and toolchain configuration (uses Java 17).
  - Extended IDE compatibility to IntelliJ 2023.1 → 2025.2.

### Developer Quality-of-Life Improvements
  - Cleaned build.gradle.kts with java.toolchain support and consistent tasks.
  - Updated CHANGELOG.md and README.md to reflect new features.
  - Renamed run configuration:
     - “Run IDE with Plugin” → “Run Plugin with debug”
  - Reduced redundancy in IntelliJ Gradle setup.
  - Added detailed debug logging for inspection suppressors.

### Summary
Area	Improvement
Template Tags	Full <th:block> support
Form Handling	Added th:field, th:errors, th:errorclass
Spring Integration	Model + Controller awareness
URL Completion	Auto-suggest Spring mappings
Expression Completion	Rich ${}, *{}, #{} suggestions
Compatibility	IntelliJ 2023.1–2025.2
Build	Modern Gradle / Java toolchain setup
📅 Release Date: 2025-11-05
🧾 Version: 1.2.0

## [1.1.0] - 2024-09-19

### New Features
- Added menu options to insert Thymeleaf, Thymeleaf Layout, and Spring Security namespaces directly into HTML files.
- Automatic registration of common Thymeleaf namespaces into the IntelliJ schema registry, reducing manual configuration effort.

### Enhancements
- Improved internal structure for managing and accessing namespace attributes and values.
- Refined UI integration to provide a better user experience when working with HTML files.
- Added support for ignoring unknown namespaces in the schema registry upon plugin installation.
- Updated compatibility settings for better support with newer IntelliJ versions.

### Bug Fixes
- Resolved issues with namespace attributes not being recognized properly in some cases.
- Fixed potential conflicts when registering namespaces in the IntelliJ schema registry.
- Addressed stability issues with autocompletion for certain namespace attributes.
- Fixed bug in SpringSecurityAttributeInfo and LayoutAttributeInfo where the descriptions were not being returned properly. This was due to using missing code during work on updating code layout and architecture.
### Notes
- The Spring Security Thymeleaf namespace defaults to the latest version. If using an earlier version, please update the namespace manually and add it to **Settings | Languages & Frameworks | Schemas and DTDs | Ignored Schemas and DTDs**.

## [1.0.0] - 2024-09-10

### Initial Release

#### New Features
- Support for Thymeleaf core attributes (`th:` namespace).
- Support for Spring Security attributes (`sec:` namespace).
- Support for Thymeleaf Layout dialect (`layout:` namespace).
- Autocomplete for all supported attributes.
- Tooltips with attribute descriptions.
- Namespace auto-insertion for Thymeleaf and other supported dialects.
- Seamless integration with HTML and XML editors in IntelliJ IDEA.

#### Bug Fixes
- Resolved duplicate attribute suggestions in autocompletion.
- Improved stability of attribute completion across different namespaces.

---

**Legend:**
- **New Features:** Added functionality that did not exist in previous versions.
- **Enhancements:** Improvements made to the existing functionality.
- **Bug Fixes:** Corrections of issues that were identified in previous versions.
- **Notes:** Additional information or considerations related to the release.
