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
      <div className="p-2 flex gap-2 text-lg bg-slate-500 text-slate-300 ">
        <Link className='hover:text-slate-100'
          to="/"
          activeProps={{
            className: 'font-bold underline text-slate-100',
          }}
          activeOptions={{ exact: true }}
        >
          Home
        </Link>{' '}
        <Link className='hover:text-slate-100'
          to="/logs"
          activeProps={{
            className: 'font-bold underline text-slate-100',
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
