
const urlLogging = "http://localhost:8090/api"


export function fetchLogItems(filter : string) {
    if(filter === "All")
    return fetch(urlLogging).then(s => s.json())
    return fetch(urlLogging+"/services/" + filter).then(s => s.json())
}

export function fetchLogItemsByService(serviceName : string) {
    return fetch(urlLogging+"/services/"+serviceName).then(s => s.json()) 
}

export function fetchServiceNames() {
    return fetch(urlLogging+"/services").then(s => s.json())
}