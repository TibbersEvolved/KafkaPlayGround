import * as React from 'react'
import { Link, Outlet, createRootRoute } from '@tanstack/react-router'
import { TanStackRouterDevtools } from '@tanstack/router-devtools'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';

export const Route = createRootRoute({
  component: RootComponent,
})

const queryClient = new QueryClient();

function RootComponent() {
  return (
    <>
    <QueryClientProvider client={queryClient}>
      <div className="p-2 flex gap-2 text-lg bg-slate-500">
        <Link
          to="/"
          activeProps={{
            className: 'font-bold',
          }}
          activeOptions={{ exact: true }}
        >
          Home
        </Link>{' '}
        <Link
          to="/logs"
          activeProps={{
            className: 'font-bold',
          }}
        >
          Logs
        </Link>
      </div>
      <hr />
      <Outlet />
      </QueryClientProvider>
    </>
  )
}
