/** @type {import('tailwindcss').Config} */
import daisyui from "daisyui";

export default {
    content: ["./src/**/*.{html,tsx,ts}"],
    daisyui: {
      themes: [],
    },
    theme: {
      extend: {},
    },
    plugins: [daisyui],
  };