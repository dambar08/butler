import { queryOptions } from '@tanstack/react-query'
import { z } from 'zod'

const healthSchema = z.object({
  status: z.string(),
  app: z.string(),
  timestamp: z.iso.datetime(),
})

export type HealthResponse = z.infer<typeof healthSchema>

async function loadHealth(): Promise<HealthResponse> {
  const response = await fetch('/api/health')

  if (!response.ok) {
    throw new Error(`Request failed with status ${response.status}`)
  }

  return healthSchema.parse(await response.json())
}

export const healthQueryOptions = queryOptions({
  queryKey: ['health'],
  queryFn: loadHealth,
})
