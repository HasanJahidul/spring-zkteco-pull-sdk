# Contributing to zkteco-pull-spring-sdk

Thanks for considering a contribution. This document explains the workflow.

## Reporting bugs

1. Check [existing issues](https://github.com/HasanJahidul/zkteco-pull-spring-sdk/issues) first.
2. Open a new issue using the **Bug report** template.
3. Include: device model, firmware version, SDK version, Java version, Spring Boot version, steps to reproduce, expected vs actual behavior, and any relevant logs.

## Requesting features

1. Open a new issue using the **Feature request** template.
2. Describe the use case before the proposed solution.

## Submitting pull requests

1. Fork the repo and create a branch from `main`: `git checkout -b feat/your-feature` or `fix/issue-123`.
2. Keep changes focused — one PR per concern.
3. Follow existing code style (4-space indent, Java conventions).
4. Add or update tests for any behavior change.
5. Update `CHANGELOG.md` under an `## [Unreleased]` section.
6. Run `mvn clean verify` locally before pushing.
7. Open the PR against `main`. CI must pass.

## Commit messages

Use [Conventional Commits](https://www.conventionalcommits.org/):
- `feat:` new feature
- `fix:` bug fix
- `docs:` documentation only
- `refactor:` code change without behavior change
- `test:` test additions or fixes
- `ci:` CI configuration changes
- `chore:` tooling, dependencies, etc.

## Code of conduct

Be respectful. Assume good intent. No harassment.

## License

By contributing, you agree your contributions are licensed under the project's [MIT License](LICENSE).
