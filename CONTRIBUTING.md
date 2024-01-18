# Contributing to BDI

*Based on Wise Building's Contributing Guidelines*

## Dependency Management

### Mandate on the use of pnpm for Package Management

In our efforts to maintain efficiency, reliability, and consistency in our development environment, we mandate the use of **pnpm** or **npm** as our package manager of choice for all JavaScript/TypeScript and Node.js projects within BDI.

## Coding Conventions

- **Variables**: Use `camelCase` for variable and function names.
- **Classes & Interfaces**: Use `PascalCase` for class names and interface names.
- **Interface Members**: Use `camelCase`.
- **Types & Enums**: Use `PascalCase` for type names and enum names.
- **Class Files**: Name class files using `PascalCase`. (ex: `MyClass.ts`)
- **Component Files**: Name component files using `PascalCase`. (ex: `MyComponent.vue`)
- **Folders & Miscellaneous Files**: Use `kebab-case` for folders and other files not previously specified. (ex: `file-utils.ts`)

## Commit Conventions

- **Commit Messages**: Follow the [Angular Commit Message Guidelines](https://github.com/angular/angular/blob/main/CONTRIBUTING.md#-commit-message-guidelines).

- **Types**: Must be one of `build`, `ci`, `docs`, `feat`, `fix`, `perf`, `refactor`, `style`, `test`, or `chore`.

- **Scope**: A scope may be provided to a commit’s type, to provide additional contextual information and is contained within parenthesis.

- **Subject**: The subject contains a succinct description of the change:

- Use the imperative, present tense: "change", not "changed" nor "changes".

- Do not capitalize the first letter.

- No dot (.) at the end.

## Branch Naming Conventions

We use Git Flow as our branching model. Here are the conventions you should follow for naming your branches:

- **Feature Branches**: Prefix with `feature/`, followed by a short descriptor of the feature (e.g., `feature/add-login`).
- **Bugfix Branches**: Prefix with `fix/`, followed by a short descriptor of the fix (e.g., `fix/login-error`).
- **Release Branches**: Prefix with `release/`, followed by the version number (e.g., `release/1.0.0`).
- **Hotfix Branches**: Prefix with `hotfix/`, followed by the version number (e.g., `hotfix/1.0.1`).
- **Maintenance/Branches for Chores**: Prefix with `chore/`, followed by a short descriptor (e.g., `chore/update-dependencies`).

## Pull Request Conventions

- **Pull Request Title**: Follow the [Angular Commit Message Guidelines](https://github.com/angular/angular/blob/main/CONTRIBUTING.md#-commit-message-guidelines)
- **Pull Request Description**: Provide a detailed description of the changes in the pull request description. Include a link to the Jira ticket if applicable.
- **Pull Request Reviewers**: Add the appropriate reviewers to the pull request.
