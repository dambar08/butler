# Copilot instructions for Butler

## Overview

This repository is a minimal Spring Boot application built with Java 25 and Gradle. The app entry point is `com.butler.app.AppApplication`, and all source code currently lives under the `com.butler.app` package. The project is intentionally thin at the moment: it bootstraps a Spring application, provides Testcontainers-based PostgreSQL support for integration tests, and is ready for additional domain logic, controllers, repositories, or service layers.

The repo also includes a Docker Compose file for a local PostgreSQL instance and a generated `HELP.md` from the Spring Initializr template. Treat the Spring Boot defaults as the baseline unless the project grows into a richer layered architecture.

## Build, test, and lint commands

Use the Gradle wrapper from the repo root rather than a system-installed Gradle.

- Build the project:
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

There is no separate lint task configured in `build.gradle`; the project relies on the default Java/Spring Boot build and test flow. If a new linting or static-analysis tool is introduced, update this section and the repo conventions accordingly.

## Architecture at a glance

- `src/main/java/com/butler/app/AppApplication.java`
  - Spring Boot application entry point.
  - Starts the app via `SpringApplication.run(...)`.
- `src/main/resources/application.properties`
  - Simple runtime configuration; currently only sets the app name.
- `src/test/java/com/butler/app/TestcontainersConfiguration.java`
  - Configures a PostgreSQL Testcontainers instance for test-time database connectivity.
- `src/test/java/com/butler/app/AppApplicationTests.java`
  - Smoke test that loads the Spring application context and verifies the app boots successfully.
- `compose.yaml`
  - Local PostgreSQL service for development or manual database testing.

The app is currently a simple bootstrapped Spring Boot service. When adding features, keep the project organized by Spring conventions: package by feature or responsibility, use Spring Boot auto-configuration where possible, and keep application configuration in `src/main/resources`.

## Key conventions

- Prefer the Gradle wrapper (`./gradlew`) over invoking `gradle` directly.
- Use Spring Boot conventions and annotations (`@SpringBootApplication`, `@SpringBootTest`, `@Configuration`, etc.) rather than custom bootstrapping logic.
- For tests that need a database, prefer the existing Testcontainers setup and keep the test class annotated with `@Import(TestcontainersConfiguration.class)`.
- Keep new code under the existing `com.butler.app` namespace unless the project expands to a more layered structure that clearly warrants additional packages.
- Favor small, focused tests that validate startup and core behavior; the repo currently uses JUnit 5 and Spring Boot’s test starters.
- When introducing new config or dependencies, keep the project aligned with the current Spring Boot 4 / Java 25 setup defined in `build.gradle`.
