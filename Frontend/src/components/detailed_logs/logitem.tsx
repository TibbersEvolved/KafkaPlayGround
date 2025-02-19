import { logDataItem } from "./logContainer"

const code200 = ""
const code400 = ""

export default function Logitem(props : prop) {
    let txt = "bg-amber-100"
    if(props.item.statusCode === 200)
        {
            txt = "bg-green-400"
        }
    if(props.item.statusCode === 400)
        {
            txt = "bg-red-400"
        }
    return (
        <>
        <section className={"flex gap-2 rounded-md p-1 " + txt}>
        <div >{props.item.serviceName}</div>
        <div>||</div>
        <div>Status: {props.item.statusCode}</div>
        <div>||</div>
        <div> {props.item.timestamp}</div>
        </section>
        </>
    )
}


type prop = {
    item : logDataItem
}