import { createFileRoute } from '@tanstack/react-router'
import UserDashboard from '../UserDashboard'

export const Route = createFileRoute('/')({
  component: UserDashboard,
})
