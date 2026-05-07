# Changelog

All notable changes to `zkteco-pull-spring-sdk` are documented here.

This project adheres to [Semantic Versioning](https://semver.org/).

---

## [1.0.3] — 2026-05-07

### Fixed
- Corrected developer metadata in `pom.xml` (typo: "Hasan Jaidul" → "Jahidul Hasan")
- Replaced placeholder developer email with `contact@hasanjahidul.com`
- Normalized GitHub URL casing (`HasanJahidul`) across `<url>` and `<scm>` tags

### Added
- Developer profile URL field in `pom.xml`
- Comprehensive `README.md` with badges, install snippets, quickstart, configuration, and adoption stats
- `CHANGELOG.md`
- GitHub Actions CI workflow (Java 17 + 21 build matrix)

### Changed
- License badge corrected from Apache 2.0 → MIT (matches actual `LICENSE` file)

---

## [1.0.2] — 2025-XX-XX

- Internal release.

## [1.0.1] — 2025-XX-XX

- Internal release.

## [1.0.0] — 2025-XX-XX

### Added
- Initial release of `zkteco-pull-spring-sdk`.
- Spring Boot auto-configuration starter.
- Pull-based polling for ZKTeco devices over TCP (port 4370).
- Connection management (connect, disconnect, status check).
- Device info retrieval (name, serial, OS version, platform, time, firmware).
- User management (fetch all, add, update, remove, clear all, clear admins).
- Attendance management (fetch all records, clear logs).
- Device controls (lock/unlock terminal, remote unlock door, power off, restart, sleep/wake).
- Time sync (get/set time).
- LCD operations (clear screen, write text).
- Voice prompt triggering.
- Network configuration commands (MAC address fetch).
- SSR / WorkCode / PIN width / face recognition feature toggle inspection.
