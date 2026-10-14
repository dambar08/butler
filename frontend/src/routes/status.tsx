import { createFileRoute } from '@tanstack/react-router'
import { StatusPage } from '../App'

export const Route = createFileRoute('/status')({
  component: StatusPage,
})
