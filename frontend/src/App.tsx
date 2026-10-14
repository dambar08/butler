import { useQuery } from '@tanstack/react-query'
import { format } from 'date-fns'
import clsx from 'clsx'
import { Activity } from 'lucide-react'
import { Link } from '@tanstack/react-router'
import { Button } from '@/components/ui/button'
import { healthQueryOptions } from './api/health'
import './App.css'

export function StatusPage() {
  const { data: health, error, isPending, isFetching, refetch } = useQuery(healthQueryOptions)

  return (
    <main className="app-shell">
      <section className="hero-panel">
        <p className="eyebrow">Butler</p>
        <h1>Spring Boot + React in TypeScript</h1>
        <p className="subtitle">
          A JHipster-inspired setup with a Java backend and a Vite-powered React UI.
        </p>
        <p className="admin-link"><Link to="/admin">Open admin dashboard</Link></p>

        <div className="status-card">
          {error ? (
            <p className="status-error" role="alert">{error.message}</p>
          ) : health ? (
            <>
              <span className={clsx('status-pill', health.status)}>
                <Activity aria-hidden="true" size={14} />
                {health.status}
              </span>
              <div className="status-details">
                <strong>{health.app}</strong>
                <time dateTime={health.timestamp}>
                  {format(new Date(health.timestamp), 'PPpp')}
                </time>
              </div>
            </>
          ) : (
            <p role="status">{isPending ? 'Loading application status…' : 'Status unavailable.'}</p>
          )}
          <Button
            className="status-refresh"
            variant="outline"
            size="sm"
            disabled={isFetching}
            onClick={() => void refetch()}
          >
            Refresh
          </Button>
        </div>
      </section>
    </main>
  )
}

export function NotFoundPage() {
  return (
    <main className="app-shell">
      <section className="hero-panel">
        <p className="eyebrow">404</p>
        <h1>Page not found</h1>
        <p className="subtitle">
          The page you requested does not exist. <Link to="/">Return to Butler</Link>
        </p>
      </section>
    </main>
  )
}
