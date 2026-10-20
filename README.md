# butler

## Admin API

Admin endpoints are available under `/admin` (and `/api/admin` for consistency
with the app API) and require HTTP Basic authentication with the `ADMIN` role.
Configure `BUTLER_ADMIN_USERNAME` and `BUTLER_ADMIN_PASSWORD` to create the
in-memory admin account. The frontend dashboard is available at `/admin`; sign
in with that account to view system health and integration status. Credentials
are kept in page memory and sent using HTTP Basic authentication. The SSO
`test_connection` endpoint checks the
provider's HTTPS OIDC discovery document. Worker AI verification, push
delivery, and hosted usage return an explicit not-configured response until
those integrations are added.

## Accounts API

Authenticated account reads are available at `GET /api/v1/accounts` and
`GET /api/v1/accounts/{id}`. The index accepts a 1-based `page` and `per_page`;
`per_page` defaults to 25 for missing, invalid, or non-positive values and is
capped at 100. Results are ordered by account name. Both endpoints are scoped
to the authenticated user's family and accounts explicitly shared with that
user. Disabled accounts are hidden unless `include_disabled=true` is supplied.

## OAuth2 / OpenID Connect login

OAuth2 login is opt-in. Activate the `oauth` Spring profile alongside the
deployment profile, and provide an OpenID Connect issuer and client credentials:

```sh
export SPRING_PROFILES_ACTIVE=development,oauth
export BUTLER_OIDC_ISSUER=https://identity.example.com
export BUTLER_OIDC_CLIENT_ID=butler
export BUTLER_OIDC_CLIENT_SECRET='replace-with-client-secret'
./gradlew bootRun
```

Register `{baseUrl}/login/oauth2/code/butler` as the callback URL with the
identity provider. Users start sign-in at `/oauth2/authorization/butler`.
When a client registration is configured, non-public routes require
authentication; admin routes still require the `ADMIN` role. Without OAuth
configuration, the existing security behavior is unchanged. Other OAuth2
providers can be configured using Spring Security's standard
`spring.security.oauth2.client` properties.

## Frontend routing

The React frontend uses TanStack Router's file-based routing. Add route modules
under `frontend/src/routes`; the current routes are `/` for the user dashboard,
`/status` for application health, and `/admin` for the admin dashboard. The
Vite plugin generates `frontend/src/routeTree.gen.ts`; do not edit that file by
hand.

Run frontend npm scripts through Gradle from the repository root:

```sh
./gradlew frontendBuild
./gradlew frontendTest
./gradlew frontendLint
./gradlew frontendCheck
```

`processResources` and the normal Gradle build also run `frontendBuild`. The
Gradle frontend install task uses `npm ci` and the committed lockfile.

## Data model

See the [entity graph](docs/entity-graph.md) for all JPA-mapped tables and their declared associations.

## Background jobs

The app uses JobRunr with the existing PostgreSQL datasource. Its background
job server is enabled by default, and JobRunr creates and manages its own
`jobrunr_*` storage tables in that database. Inject `JobScheduler` into a
Spring-managed service to enqueue work:

```java
@Service
class ReportQueue {
    private final JobScheduler jobScheduler;
    private final ReportService reportService;

    ReportQueue(JobScheduler jobScheduler, ReportService reportService) {
        this.jobScheduler = jobScheduler;
        this.reportService = reportService;
    }

    void enqueue(UUID reportId) {
        jobScheduler.enqueue(() -> reportService.generate(reportId));
    }
}
```

The JobRunr dashboard is disabled by default. Enable it only when its port is
protected and dashboard authentication is configured; see the
[JobRunr Spring Boot configuration](https://www.jobrunr.io/en/documentation/configuration/spring/).

## Deploy with Helm

Build and push the application image to a registry your Kubernetes cluster can
access:

```sh
docker build -t ghcr.io/<owner>/butler:0.0.1 .
docker push ghcr.io/<owner>/butler:0.0.1

docker build -f frontend/Dockerfile -t ghcr.io/<owner>/butler-frontend:0.0.1 .
docker push ghcr.io/<owner>/butler-frontend:0.0.1
```

Create the namespace and a Secret for PostgreSQL credentials. The chart expects
the Secret to contain `username` and `password` keys:

```sh
kubectl create namespace butler
kubectl -n butler create secret generic butler-postgresql \
  --from-literal=username=postgres \
  --from-literal=password="$POSTGRES_PASSWORD"
```

Install or upgrade the application and its PostgreSQL StatefulSet:

```sh
helm upgrade --install butler ./charts/butler \
  --namespace butler \
  --set app.image.repository=ghcr.io/<owner>/butler \
  --set app.image.tag=0.0.1 \
  --set frontend.image.repository=ghcr.io/<owner>/butler-frontend \
  --set frontend.image.tag=0.0.1 \
  --set postgresql.auth.existingSecret=butler-postgresql
```

The chart deploys the frontend as a separate Nginx Deployment and Service. The
frontend Service serves the React app, forwards `/api/` requests to the backend
Service, and supports client-side route fallback. Set
`frontend.service.type=LoadBalancer` (or configure an Ingress) to expose it
outside the cluster.

The chart also supports creating the database Secret from chart values by
setting `postgresql.auth.password`; use a pre-created Secret for deployments
where credentials should not be stored in Helm release values. PostgreSQL data
is stored in a persistent volume by default. Set `postgresql.enabled=false`
and configure `app.database.url` and `app.database.secretName` to connect to an
external PostgreSQL database; that Secret should contain the keys configured
by `app.database.usernameKey` and `app.database.passwordKey`.

The chart defaults to the `development` Spring profile so a fresh database can
initialize its schema. For a database whose schema is already provisioned,
select another profile with `--set app.springProfiles=production`.

Access the app locally with:

```sh
kubectl -n butler port-forward service/butler 8080:80
```

Use the frontend service to access the separately deployed UI:

```sh
kubectl -n butler port-forward service/butler-frontend 8080:80
```

Validate chart rendering before installation:

```sh
helm lint ./charts/butler --set postgresql.auth.password=lint-only
helm template butler ./charts/butler --set postgresql.auth.password=render-only
```

See `charts/butler/values.yaml` for image, service, storage, resource, and
database configuration.
