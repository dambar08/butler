# Copilot instructions for Butler

## Overview

This repository combines a Spring Boot 4 backend (Java 25, Gradle) with a React/TypeScript frontend built by Vite. `com.butler.app.AppApplication` serves the backend and the built static frontend. Backend code is grouped under `com.butler.app` by API, configuration, and entities.

The repo includes Docker Compose for local PostgreSQL, a Dockerfile for the combined application image, and a Helm chart under `charts/butler` that deploys the app with PostgreSQL by default.

## Build, test, and lint commands

Use the Gradle wrapper from the repo root rather than a system-installed Gradle.

- Build backend and frontend:
  - `./gradlew build`
- Run the app locally:
  - `./gradlew bootRun`
- Run the full test suite:
  - `./gradlew test`
- Run a single test class:
  - `./gradlew test --tests "com.butler.app.AppApplicationTests"`
- Run a single test method:
  - `./gradlew test --tests "com.butler.app.AppApplicationTests.contextLoads"`
- Clean and rebuild:
  - `./gradlew clean test`
- Run Java style checks:
  - `./gradlew checkstyleMain checkstyleTest`
- Run frontend checks:
  - `./gradlew frontendCheck`
- Run the frontend tests:
  - `./gradlew frontendTest`
- Run the frontend linter:
  - `./gradlew frontendLint`
- Build the frontend directly:
  - `./gradlew frontendBuild`
- Build the container image:
  - `docker build -t butler:0.0.1 .`
- Build the standalone frontend image:
  - `docker build -f frontend/Dockerfile -t butler-frontend:0.0.1 .`
- Lint and render the Helm chart (supply a password for local validation or configure an existing Kubernetes Secret):
  - `helm lint ./charts/butler --set postgresql.auth.password=lint-only`
  - `helm template butler ./charts/butler --set postgresql.auth.password=render-only`

The Gradle `processResources` task runs the frontend install/build tasks; `./gradlew test` therefore also builds the frontend and runs its tests. The Java tests use Testcontainers PostgreSQL, so Docker must be available when running tests.

## Architecture at a glance

- `src/main/java/com/butler/app`
  - Spring Boot application plus API, security/web configuration, and JPA entities.
- `frontend`
  - React/TypeScript application. Vite emits production assets into `src/main/resources/static` for the combined Spring Boot image; `frontend/Dockerfile` packages the same build into a standalone Nginx image.
- `src/main/resources/application*.yml`
  - Shared and profile-specific application configuration. The development profile updates the JPA schema; staging/production validate it.
- `src/test/java/com/butler/app/TestcontainersConfiguration.java`
  - Configures a PostgreSQL Testcontainers instance for test-time database connectivity.
- `src/test/java/com/butler/app/AppApplicationTests.java`
  - Smoke test that loads the Spring application context and verifies the app boots successfully.
- `compose.yaml`
  - Local PostgreSQL service for development or manual database testing.
- `Dockerfile`
  - Builds the executable Spring Boot jar with the Gradle wrapper, then packages it in a Java 25 runtime image.
- `charts/butler`
  - Helm chart for separate backend and frontend Deployments/Services plus an optional PostgreSQL StatefulSet, Services, Secret, and persistent volume claim. The frontend Service proxies `/api/` to the backend.

The frontend build runs as part of Gradle resource processing, so built UI assets are packaged into the same Spring Boot jar and container image as the API. Use the Gradle frontend tasks instead of invoking npm scripts directly for routine build, test, and lint work.

## Repository guidance

- Follow `AGENTS.md` for repository-level agent workflows. GitHub issue operations use the `gh` CLI; issue conventions and triage labels are documented in `docs/agents/issue-tracker.md` and `docs/agents/triage-labels.md`.
- Before changing domain terminology or architecture, consult the relevant glossary and ADRs as described in `docs/agents/domain.md`.

## Key conventions

- Prefer the Gradle wrapper (`./gradlew`) over invoking `gradle` directly; its resource-processing task also runs the frontend build.
- Use Spring Boot conventions and annotations (`@SpringBootApplication`, `@SpringBootTest`, `@Configuration`, etc.) rather than custom bootstrapping logic.
- For tests that need a database, prefer the existing Testcontainers setup and keep the test class annotated with `@Import(TestcontainersConfiguration.class)`.
- Keep backend code under `com.butler.app`, following the existing `api`, `config`, and `entities` package organization.
- Keep browser code in `frontend`; Vite's output directory is `src/main/resources/static`, so avoid maintaining a second copy of built assets.
- When deploying the frontend separately, build and publish `frontend/Dockerfile` as well as the root backend Dockerfile; the chart expects both image references.
- Favor small, focused tests that validate startup and core behavior; the repo currently uses JUnit 5 and Spring Boot’s test starters.
- When introducing new config or dependencies, keep the project aligned with the current Spring Boot 4 / Java 25 setup defined in `build.gradle`.
- Keep the chart's app image configurable; build and publish the Docker image separately before deploying it to a cluster.
- The Helm chart uses an existing Kubernetes Secret for PostgreSQL credentials when `postgresql.auth.existingSecret` is set. Its default credential keys are `username` and `password`; do not put production credentials in committed values files.
- When configuring an external database, set `app.database.url` and `app.database.secretName` together, and configure the secret key names through `app.database.usernameKey` and `app.database.passwordKey`.
- The Helm chart defaults to the `development` profile to initialize a new database; use `app.springProfiles=production` only when the database schema is already provisioned.
