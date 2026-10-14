import { createRootRoute } from '@tanstack/react-router'
import { NotFoundPage } from '../App'
import RootLayout from '../RootLayout'

export const Route = createRootRoute({
  component: RootLayout,
  notFoundComponent: NotFoundPage,
})
