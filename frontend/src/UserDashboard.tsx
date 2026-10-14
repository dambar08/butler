import { useQuery } from '@tanstack/react-query'
import { format } from 'date-fns'
import clsx from 'clsx'
import {
  ArrowDownLeft,
  ArrowUpRight,
  BarChart3,
  ChevronDown,
  CircleHelp,
  CreditCard,
  LayoutDashboard,
  Plus,
  Settings,
  ShieldCheck,
  Sparkles,
  Target,
  Wallet,
} from 'lucide-react'
import { useState } from 'react'
import { Link } from '@tanstack/react-router'
import { healthQueryOptions } from './api/health'
import './UserDashboard.css'

const navigation = [
  { label: 'Overview', href: '#overview', icon: LayoutDashboard },
  { label: 'Accounts', href: '#accounts', icon: Wallet },
  { label: 'Transactions', href: '#transactions', icon: ArrowDownLeft },
  { label: 'Budgets', href: '#budgets', icon: BarChart3 },
  { label: 'Goals', href: '#goals', icon: Target },
]

function ServiceStatus() {
  const { data: health, error, isPending } = useQuery(healthQueryOptions)

  return (
    <div className="service-status">
      <span
        className={clsx('service-indicator', {
          'is-online': health?.status === 'ok',
          'is-offline': error,
        })}
        aria-hidden="true"
      />
      <div>
        <span className="service-label">Service status</span>
        <span className="service-value" role={error ? 'alert' : 'status'}>
          {error
            ? 'Unavailable'
            : health
              ? 'All systems operational'
              : isPending
                ? 'Checking…'
                : 'Status unavailable'}
        </span>
      </div>
      <ShieldCheck aria-hidden="true" size={17} />
    </div>
  )
}

function EmptyState({
  icon: Icon,
  title,
  description,
}: {
  icon: typeof Wallet
  title: string
  description: string
}) {
  return (
    <div className="empty-state">
      <span className="empty-icon"><Icon aria-hidden="true" size={20} /></span>
      <strong>{title}</strong>
      <p>{description}</p>
    </div>
  )
}

function UserDashboard() {
  const [today] = useState(() => format(new Date(), 'EEEE, MMMM d'))

  return (
    <div className="dashboard-shell">
      <aside className="sidebar">
        <Link className="brand" to="/" aria-label="Butler home">
          <span className="brand-mark"><Sparkles aria-hidden="true" size={19} /></span>
          <span>butler</span>
        </Link>

        <div className="workspace-switcher">
          <span className="workspace-avatar">Y</span>
          <span className="workspace-copy">
            <strong>Your workspace</strong>
            <span>Personal</span>
          </span>
          <ChevronDown aria-hidden="true" size={15} />
        </div>

        <p className="nav-heading">Workspace</p>
        <nav className="primary-nav" aria-label="Main navigation">
          {navigation.map(({ label, href, icon: Icon }, index) => (
            <a
              className={clsx('nav-link', { 'is-active': index === 0 })}
              href={href}
              key={label}
              aria-current={index === 0 ? 'page' : undefined}
            >
              <Icon aria-hidden="true" size={18} />
              <span>{label}</span>
              {label === 'Transactions' && <span className="nav-count">0</span>}
            </a>
          ))}
        </nav>

        <div className="sidebar-spacer" />
        <button className="nav-link muted-link" type="button" disabled title="Coming soon">
          <CircleHelp aria-hidden="true" size={18} />
          <span>Help &amp; support</span>
        </button>
        <button className="nav-link muted-link" type="button" disabled title="Coming soon">
          <Settings aria-hidden="true" size={18} />
          <span>Settings</span>
        </button>
        <ServiceStatus />
        <button className="profile-button" type="button" disabled>
          <span className="profile-avatar">Y</span>
          <span className="profile-copy">
            <strong>Your profile</strong>
            <span>Personal account</span>
          </span>
          <ChevronDown aria-hidden="true" size={15} />
        </button>
      </aside>

      <main className="main-content" id="overview">
        <header className="topbar">
          <div className="breadcrumb"><span>Workspace</span><span>/</span><strong>Overview</strong></div>
          <div className="topbar-actions">
            <span className="today-label">{today}</span>
            <button className="help-button" type="button" aria-label="Help" disabled>
              <CircleHelp aria-hidden="true" size={18} />
            </button>
          </div>
        </header>

        <div className="page-content">
          <section className="welcome-row">
            <div>
              <p className="eyebrow">YOUR FINANCIAL HOME</p>
              <h1>Your money, in view.</h1>
              <p className="page-subtitle">A clearer picture of your finances starts here.</p>
            </div>
            <a className="primary-button" href="#accounts">
              <Plus aria-hidden="true" size={17} />
              Get started
            </a>
          </section>

          <section className="summary-grid" aria-label="Financial summary">
            <article className="summary-card net-worth-card">
              <div className="summary-card-top">
                <span className="summary-label">Net worth</span>
                <span className="summary-icon violet"><Wallet aria-hidden="true" size={17} /></span>
              </div>
              <strong className="summary-value">—</strong>
              <span className="summary-note">Your total will appear when account sync is available</span>
              <div className="mini-chart" aria-hidden="true">
                <span /><span /><span /><span /><span /><span /><span /><span /><span /><span /><span /><span />
              </div>
            </article>
            <article className="summary-card">
              <div className="summary-card-top">
                <span className="summary-label">Income</span>
                <span className="summary-icon green"><ArrowDownLeft aria-hidden="true" size={17} /></span>
              </div>
              <strong className="summary-value">—</strong>
              <span className="summary-note">This month</span>
              <div className="summary-footnote">No income data yet</div>
            </article>
            <article className="summary-card">
              <div className="summary-card-top">
                <span className="summary-label">Spending</span>
                <span className="summary-icon orange"><ArrowUpRight aria-hidden="true" size={17} /></span>
              </div>
              <strong className="summary-value">—</strong>
              <span className="summary-note">This month</span>
              <div className="summary-footnote">No spending data yet</div>
            </article>
            <article className="summary-card">
              <div className="summary-card-top">
                <span className="summary-label">Savings rate</span>
                <span className="summary-icon blue"><Sparkles aria-hidden="true" size={17} /></span>
              </div>
              <strong className="summary-value">—</strong>
              <span className="summary-note">Based on monthly income</span>
              <div className="summary-footnote">Ready when you are</div>
            </article>
          </section>

          <section className="content-grid">
            <article className="panel spending-panel" id="cash-flow">
              <div className="panel-header">
                <div>
                  <h2>Cash flow</h2>
                  <p>Income and spending over time</p>
                </div>
                <button className="period-button" type="button" disabled>
                  This year <ChevronDown aria-hidden="true" size={15} />
                </button>
              </div>
              <div className="chart-empty">
                <div className="chart-grid" aria-hidden="true">
                  <span /><span /><span /><span />
                </div>
                <div className="chart-empty-message">
                  <span className="empty-icon"><BarChart3 aria-hidden="true" size={20} /></span>
                  <strong>Your cash flow will show up here</strong>
                  <p>Your income and spending trends will appear when account sync is available.</p>
                </div>
                <div className="chart-months" aria-hidden="true">
                  <span>Jan</span><span>Feb</span><span>Mar</span><span>Apr</span><span>May</span><span>Jun</span>
                </div>
              </div>
            </article>

            <article className="panel accounts-panel" id="accounts">
              <div className="panel-header">
                <div>
                  <h2>Accounts</h2>
                  <p>Your connected accounts</p>
                </div>
                <a className="text-link" href="#get-started">View all</a>
              </div>
              <EmptyState
                icon={CreditCard}
                title="No accounts connected"
                description="Account syncing is not available yet. Your connected accounts will appear here."
              />
              <button className="account-cta" type="button" disabled>
                <Plus aria-hidden="true" size={16} />
                Account connections coming soon
              </button>
            </article>
          </section>

          <section className="bottom-grid">
            <article className="panel activity-panel" id="transactions">
              <div className="panel-header">
                <div>
                  <h2>Recent transactions</h2>
                  <p>Your latest activity at a glance</p>
                </div>
                <a className="text-link" href="#transactions">See all</a>
              </div>
              <EmptyState
                icon={ArrowDownLeft}
                title="Nothing to see just yet"
                description="Your transactions will appear here once your accounts are connected."
              />
            </article>

            <article className="panel planning-panel">
              <div className="panel-header">
                <div>
                  <h2>Plan ahead</h2>
                  <p>Keep your financial goals in reach</p>
                </div>
              </div>
              <div className="planning-items">
                <div className="planning-item" id="budgets">
                  <span className="planning-icon orange"><BarChart3 aria-hidden="true" size={17} /></span>
                  <span><strong>Budgets</strong><small>Set a plan for your spending</small></span>
                  <span className="coming-soon">Get started</span>
                </div>
                <div className="planning-item" id="goals">
                  <span className="planning-icon violet"><Target aria-hidden="true" size={17} /></span>
                  <span><strong>Savings goals</strong><small>Make progress toward what matters</small></span>
                  <span className="coming-soon">Get started</span>
                </div>
              </div>
            </article>
          </section>

          <section className="getting-started" id="get-started">
            <div className="getting-started-icon"><Sparkles aria-hidden="true" size={19} /></div>
            <div>
              <strong>Make Butler your financial home</strong>
              <p>Account syncing is coming soon. Your financial overview will fill in when it is available.</p>
            </div>
            <a className="text-link" href="#accounts">Explore accounts <span aria-hidden="true">→</span></a>
          </section>
        </div>
      </main>
    </div>
  )
}

export default UserDashboard
