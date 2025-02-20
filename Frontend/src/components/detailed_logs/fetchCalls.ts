
const urlLogging = "http://localhost:8090/api"


export function fetchLogItems() {
    return fetch(urlLogging).then(s => s.json())
}

export function fetchServiceNames() {
    return fetch(urlLogging+"/services").then(s => s.json())
}