import * as React from 'react'
import { createFileRoute } from '@tanstack/react-router'
import Launchpad from '../components/launchpad/launchpad'

export const Route = createFileRoute('/')({
  component: HomeComponent,
})

function HomeComponent() {
  return (
    <div className="p-2">
      <h3>Launchpad!</h3>
      <Launchpad/>
    </div>
  )
}
