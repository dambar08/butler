import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import { createMemoryHistory, createRouter, RouterProvider } from '@tanstack/react-router'
import { cleanup, fireEvent, render, screen } from '@testing-library/react'
import { afterEach, beforeEach, describe, expect, it, vi } from 'vitest'
import { Button } from '@/components/ui/button'
import { routeTree } from './routeTree.gen'

function renderApp(initialEntry = '/') {
  const queryClient = new QueryClient({
    defaultOptions: { queries: { retry: false } },
  })
  const router = createRouter({
    routeTree,
    history: createMemoryHistory({ initialEntries: [initialEntry] }),
  })

  return render(
    <QueryClientProvider client={queryClient}>
      <RouterProvider router={router} />
    </QueryClientProvider>,
  )
}

describe('App', () => {
  beforeEach(() => {
    vi.stubGlobal(
      'fetch',
      vi.fn().mockResolvedValue(
        new Response(
          JSON.stringify({
            status: 'ok',
            app: 'butler',
            timestamp: '2026-10-13T00:00:00Z',
          }),
          { status: 200, headers: { 'Content-Type': 'application/json' } },
        ),
      ),
    )
  })

  afterEach(() => {
    cleanup()
    vi.unstubAllGlobals()
  })

  it('shows backend health after loading', async () => {
    renderApp('/status')

    expect(await screen.findByText('butler')).toBeInTheDocument()
    expect(screen.getByText('ok')).toBeInTheDocument()
  })

  it('shows the user finance dashboard at the home route', async () => {
    renderApp()

    expect(await screen.findByRole('heading', { name: 'Your money, in view.' })).toBeInTheDocument()
    expect(screen.getByRole('heading', { name: 'Accounts' })).toBeInTheDocument()
    expect(screen.getByText('No accounts connected')).toBeInTheDocument()
    expect(await screen.findByText('All systems operational')).toBeInTheDocument()
  })

  it('shows a not-found page for unknown routes', async () => {
    renderApp('/missing')

    expect(await screen.findByRole('heading', { name: 'Page not found' })).toBeInTheDocument()
    expect(screen.getByRole('link', { name: 'Return to Butler' })).toHaveAttribute('href', '/')
  })

  it('loads the admin dashboard with HTTP Basic credentials', async () => {
    vi.stubGlobal(
      'fetch',
      vi.fn((input: RequestInfo | URL) => {
        const path = input instanceof Request ? input.url : input.toString()
        const bodies: Record<string, unknown> = {
          '/api/admin/system_health': {
            status: 'ok',
            database: 'connected',
            timestamp: '2026-10-13T00:00:00Z',
          },
          '/api/admin/system_health/ai_status': {
            configured: true,
            status: 'configured',
          },
          '/api/admin/system_health/hosted_usage': {
            status: 'unavailable',
            message: 'Hosted usage reporting is not configured.',
          },
        }

        return Promise.resolve(
          new Response(JSON.stringify(bodies[path]), {
            status: 200,
            headers: { 'Content-Type': 'application/json' },
          }),
        )
      }),
    )
    renderApp('/admin')

    fireEvent.change(await screen.findByLabelText('Username'), { target: { value: 'admin' } })
    fireEvent.change(await screen.findByLabelText('Password'), { target: { value: 'secret' } })
    fireEvent.click(await screen.findByRole('button', { name: 'Sign in' }))

    expect(await screen.findByText('Application is responding normally.')).toBeInTheDocument()
    expect(screen.getByText('Hosted usage reporting is not configured.')).toBeInTheDocument()
    expect(fetch).toHaveBeenCalledWith(
      '/api/admin/system_health',
      expect.objectContaining({
        headers: { Authorization: 'Basic YWRtaW46c2VjcmV0' },
      }),
    )
  })

  it('shows an explicit message when an admin action is not configured', async () => {
    vi.stubGlobal(
      'fetch',
      vi.fn((input: RequestInfo | URL) => {
        const path = input instanceof Request ? input.url : input.toString()
        const bodies: Record<string, unknown> = {
          '/api/admin/system_health': {
            status: 'ok',
            database: 'connected',
            timestamp: '2026-10-13T00:00:00Z',
          },
          '/api/admin/system_health/ai_status': { configured: false, status: 'not_configured' },
          '/api/admin/system_health/hosted_usage': {
            status: 'unavailable',
            message: 'Hosted usage reporting is not configured.',
          },
          '/api/admin/system_health/verify_worker_ai': {
            success: false,
            message: 'Worker AI verification is not configured.',
          },
        }

        return Promise.resolve(
          new Response(JSON.stringify(bodies[path]), {
            status: path.endsWith('/verify_worker_ai') ? 501 : 200,
            headers: { 'Content-Type': 'application/json' },
          }),
        )
      }),
    )
    renderApp('/admin')
    fireEvent.change(await screen.findByLabelText('Username'), { target: { value: 'admin' } })
    fireEvent.change(await screen.findByLabelText('Password'), { target: { value: 'secret' } })
    fireEvent.click(await screen.findByRole('button', { name: 'Sign in' }))

    fireEvent.click(await screen.findByRole('button', { name: 'Verify worker AI' }))

    expect(await screen.findByRole('alert')).toHaveTextContent(
      'Worker AI verification is not configured.',
    )
  })

  it('renders shadcn buttons with their variant classes', () => {
    render(<Button variant="secondary">Save changes</Button>)

    expect(screen.getByRole('button', { name: 'Save changes' })).toHaveClass(
      'bg-secondary',
      'text-secondary-foreground',
    )
  })
})
