# Butler frontend

The frontend is a React 19 and TypeScript application built with Vite. Spring
Boot serves its production assets from `src/main/resources/static`.

Tailwind CSS 4 is integrated through the Vite plugin. shadcn/ui is configured
with the New York style, CSS variables, Lucide icons, and the `@/` source
alias. A shared `cn` helper and starter Button component are available in
`src/lib/utils.ts` and `src/components/ui/button.tsx`.

## Development

```sh
./gradlew frontendDev
```

The Vite development server proxies `/api` requests to Spring Boot on
`http://localhost:8080`.

## Gradle tasks

Run these commands from the repository root:

| Command | Purpose |
| --- | --- |
| `./gradlew frontendInstall` | Install frontend dependencies with `npm ci` |
| `./gradlew frontendBuild` | Type-check and build production assets |
| `./gradlew frontendLint` | Run Oxlint |
| `./gradlew frontendTest` | Run component tests once |
| `./gradlew frontendTestCoverage` | Run component tests with V8 coverage |
| `./gradlew frontendCheck` | Run frontend tests and lint |
| `./gradlew frontendDev` | Run the Vite development server |
| `./gradlew frontendPreview` | Preview the production build |

Gradle runs the frontend production build as part of Spring Boot resource
processing. The standard `test` and `check` tasks also include frontend tests
and linting, respectively.

## Included application packages

- TanStack Router for file-based client-side routing.
- TanStack Query and its devtools for server state and API requests.
- React Hook Form, Zod, and the resolver adapter for typed form validation.
- Zustand for lightweight client-side state.
- Tailwind CSS, `clsx`, Lucide React, and date-fns for UI styling and common
  presentation needs.
- Vitest, Testing Library, and jsdom for component tests.
