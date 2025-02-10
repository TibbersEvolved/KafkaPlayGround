import * as React from 'react'
import { createFileRoute } from '@tanstack/react-router'
import Logui from '../components/detailed_logs/logui'

export const Route = createFileRoute('/logs')({
  component: AboutComponent,
})

function AboutComponent() {
  return (
    <div className="p-2">
      <h3>Logs</h3>
      <Logui/>
    </div>
  )
}
