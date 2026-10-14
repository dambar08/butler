import { createFileRoute } from '@tanstack/react-router'
import AdminDashboard from '../AdminDashboard'

export const Route = createFileRoute('/admin')({
  component: AdminDashboard,
})
