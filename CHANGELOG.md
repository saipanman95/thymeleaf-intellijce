# Changelog

All notable changes to this project will be documented in this file.

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
