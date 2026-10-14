import { useMutation, useQuery, useQueryClient } from '@tanstack/react-query'
import { format } from 'date-fns'
import { Activity, Bot, Database, Gauge, LogOut, RefreshCw, Send, type LucideIcon } from 'lucide-react'
import { useState, type FormEvent, type ReactNode } from 'react'
import { Link } from '@tanstack/react-router'
import { z } from 'zod'
import './AdminDashboard.css'

const systemHealthSchema = z.object({
  status: z.string(),
  database: z.string(),
  timestamp: z.iso.datetime(),
})

const aiStatusSchema = z.object({
  configured: z.boolean(),
  status: z.string(),
})

const hostedUsageSchema = z.object({
  status: z.string(),
  message: z.string(),
})

const actionResponseSchema = z.object({
  success: z.boolean(),
  message: z.string(),
})

type SystemHealth = z.infer<typeof systemHealthSchema>
type AiStatus = z.infer<typeof aiStatusSchema>
type HostedUsage = z.infer<typeof hostedUsageSchema>
type ActionResponse = z.infer<typeof actionResponseSchema>

class AdminApiError extends Error {
  readonly status: number

  constructor(message: string, status: number) {
    super(message)
    this.name = 'AdminApiError'
    this.status = status
  }
}

async function getAdminData<T>(path: string, token: string, schema: z.ZodType<T>): Promise<T> {
  const response = await fetch(path, {
    headers: { Authorization: `Basic ${token}` },
  })

  if (!response.ok) {
    throw new AdminApiError(`Request failed with status ${response.status}`, response.status)
  }

  return schema.parse(await response.json())
}

async function postAdminAction(path: string, token: string): Promise<ActionResponse> {
  const response = await fetch(path, {
    method: 'POST',
    headers: { Authorization: `Basic ${token}` },
  })
  const body = actionResponseSchema.parse(await response.json())

  if (!response.ok) {
    throw new AdminApiError(body.message, response.status)
  }

  return body
}

function encodeCredentials(username: string, password: string) {
  const bytes = new TextEncoder().encode(`${username}:${password}`)
  return btoa(Array.from(bytes, (byte) => String.fromCharCode(byte)).join(''))
}

function DataCard({
  title,
  icon: Icon,
  children,
}: {
  title: string
  icon: LucideIcon
  children: ReactNode
}) {
  return (
    <section className="admin-card">
      <div className="admin-card-heading">
        <span className="admin-icon"><Icon aria-hidden="true" size={18} /></span>
        <h2>{title}</h2>
      </div>
      {children}
    </section>
  )
}

function AdminDashboard() {
  const queryClient = useQueryClient()
  const [token, setToken] = useState('')
  const [querySessionId, setQuerySessionId] = useState(0)
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')

  const healthQuery = useQuery({
    queryKey: ['admin', 'system-health', querySessionId],
    queryFn: () => getAdminData('/api/admin/system_health', token, systemHealthSchema),
    enabled: Boolean(token),
    retry: false,
  })
  const aiQuery = useQuery({
    queryKey: ['admin', 'ai-status', querySessionId],
    queryFn: () => getAdminData('/api/admin/system_health/ai_status', token, aiStatusSchema),
    enabled: Boolean(token),
    retry: false,
  })
  const usageQuery = useQuery({
    queryKey: ['admin', 'hosted-usage', querySessionId],
    queryFn: () => getAdminData('/api/admin/system_health/hosted_usage', token, hostedUsageSchema),
    enabled: Boolean(token),
    retry: false,
  })
  const actionMutation = useMutation({
    mutationFn: ({ path }: { path: string }) => postAdminAction(path, token),
  })

  const isUnauthorized = healthQuery.error instanceof AdminApiError && healthQuery.error.status === 401
  const showLogin = !token || isUnauthorized

  function submitCredentials(event: FormEvent<HTMLFormElement>) {
    event.preventDefault()
    setQuerySessionId((current) => current + 1)
    setToken(encodeCredentials(username, password))
    setPassword('')
  }

  function logout() {
    queryClient.removeQueries({ queryKey: ['admin'] })
    setToken('')
    setUsername('')
    setPassword('')
    actionMutation.reset()
  }

  function runAction(path: string) {
    actionMutation.mutate({ path })
  }

  const actionError = actionMutation.error
  if (showLogin) {
    return (
      <main className="admin-page admin-login-page">
        <section className="admin-login-card">
          <p className="admin-eyebrow">Butler administration</p>
          <h1>Sign in to your dashboard</h1>
          <p className="admin-intro">Use the admin account configured for this Butler server.</p>
          {isUnauthorized && (
            <p className="admin-alert" role="alert">
              The username or password was not accepted.
            </p>
          )}
          <form className="admin-login-form" onSubmit={submitCredentials}>
            <label>
              Username
              <input
                autoComplete="username"
                value={username}
                onChange={(event) => setUsername(event.target.value)}
                required
              />
            </label>
            <label>
              Password
              <input
                type="password"
                autoComplete="current-password"
                value={password}
                onChange={(event) => setPassword(event.target.value)}
                required
              />
            </label>
            <button className="admin-primary-button" type="submit">Sign in</button>
          </form>
          <Link className="admin-back-link" to="/">Back to Butler status</Link>
        </section>
      </main>
    )
  }

  return (
    <main className="admin-page">
      <header className="admin-header">
        <div>
          <p className="admin-eyebrow">Butler / Administration</p>
          <h1>System dashboard</h1>
          <p className="admin-intro">Monitor service health and operational integrations.</p>
        </div>
        <div className="admin-header-actions">
          <button
            className="admin-secondary-button"
            onClick={() => {
              void healthQuery.refetch()
              void aiQuery.refetch()
              void usageQuery.refetch()
            }}
            type="button"
          >
            <RefreshCw aria-hidden="true" size={16} /> Refresh
          </button>
          <button className="admin-secondary-button" onClick={logout} type="button">
            <LogOut aria-hidden="true" size={16} /> Sign out
          </button>
        </div>
      </header>

      <div className="admin-summary">
        <DataCard title="Application health" icon={Activity}>
          <QueryValue
            data={healthQuery.data}
            isPending={healthQuery.isPending}
            error={healthQuery.error}
            loading="Checking application…"
            render={(health: SystemHealth) => (
              <>
                <StatusTag value={health.status} />
                <p className="admin-detail">Application is responding normally.</p>
                <time className="admin-muted" dateTime={health.timestamp}>
                  Checked {format(new Date(health.timestamp), 'PPpp')}
                </time>
              </>
            )}
          />
        </DataCard>

        <DataCard title="Database" icon={Database}>
          <QueryValue
            data={healthQuery.data}
            isPending={healthQuery.isPending}
            error={healthQuery.error}
            loading="Checking database…"
            render={(health: SystemHealth) => (
              <>
                <StatusTag value={health.database} />
                <p className="admin-detail">Connection status</p>
              </>
            )}
          />
        </DataCard>

        <DataCard title="AI integration" icon={Bot}>
          <QueryValue
            data={aiQuery.data}
            isPending={aiQuery.isPending}
            error={aiQuery.error}
            loading="Checking AI configuration…"
            render={(ai: AiStatus) => (
              <>
                <StatusTag value={ai.configured ? 'configured' : 'not configured'} />
                <p className="admin-detail">Worker AI configuration</p>
              </>
            )}
          />
        </DataCard>

        <DataCard title="Hosted usage" icon={Gauge}>
          <QueryValue
            data={usageQuery.data}
            isPending={usageQuery.isPending}
            error={usageQuery.error}
            loading="Checking usage reporting…"
            render={(usage: HostedUsage) => (
              <>
                <StatusTag value={usage.status} />
                <p className="admin-detail">{usage.message}</p>
              </>
            )}
          />
        </DataCard>
      </div>

      <section className="admin-operations">
        <div className="admin-section-heading">
          <div>
            <p className="admin-eyebrow">Operations</p>
            <h2>Integration checks</h2>
          </div>
          <p>Run a test to confirm the configured worker and push services are responding.</p>
        </div>
        <div className="admin-action-row">
          <button
            className="admin-primary-button"
            disabled={actionMutation.isPending}
            onClick={() => runAction('/api/admin/system_health/verify_worker_ai')}
            type="button"
          >
            <Bot aria-hidden="true" size={17} />
            {actionMutation.isPending ? 'Running check…' : 'Verify worker AI'}
          </button>
          <button
            className="admin-secondary-button"
            disabled={actionMutation.isPending}
            onClick={() => runAction('/api/admin/system_health/send_test_push')}
            type="button"
          >
            <Send aria-hidden="true" size={17} /> Send test push
          </button>
        </div>
        {actionMutation.data && (
          <p className={actionMutation.data.success ? 'admin-action-success' : 'admin-alert'} role="status">
            {actionMutation.data.message}
          </p>
        )}
        {actionError && (
          <p className="admin-alert" role="alert">
            {actionError.message}
          </p>
        )}
      </section>

      <footer className="admin-footer">
        <Link to="/">Back to Butler status</Link>
        <span>Admin credentials are kept only for this page session.</span>
      </footer>
    </main>
  )
}

function StatusTag({ value }: { value: string }) {
  const normalized = value.toLowerCase().replaceAll(' ', '_')
  return <span className={`admin-status-tag ${normalized}`}>{value}</span>
}

function QueryValue<T>({
  data,
  isPending,
  error,
  loading,
  render,
}: {
  data: T | undefined
  isPending: boolean
  error: Error | null
  loading: string
  render: (value: T) => ReactNode
}) {
  if (error) {
    return <p className="admin-alert" role="alert">{error.message}</p>
  }
  if (isPending) {
    return <p className="admin-muted" role="status">{loading}</p>
  }

  return data === undefined ? null : render(data)
}

export default AdminDashboard
