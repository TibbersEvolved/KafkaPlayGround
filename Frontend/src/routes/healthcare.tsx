import * as React from 'react'
import { createFileRoute } from '@tanstack/react-router'
import Healthcare from '../components/healthcare/healthcare'

export const Route = createFileRoute('/healthcare')({
  component: AboutComponent,
})

function AboutComponent() {
  return (
    <div className="p-2">
      <h3>Healthcare</h3>
      <Healthcare/>
    </div>
  )
}
