import { useState } from "react"
import { logDataItem } from "./logContainer"

const code200 = ""
const code400 = ""

export default function Logitem(props : prop) {
    const [selectId, setSelectId] = useState(false);
    let txt = "bg-amber-100"
    if(props.item.statusCode === 200)
        {
            txt = "bg-green-400 hover:bg-green-200"
        }
    if(props.item.statusCode === 400)
        {
            txt = "bg-red-400 hover:bg-red-200"
        }
    if(selectId == false)
    return (
        <>
        <section className={"flex gap-2 rounded-md p-1 ml-2 mr-2 font-light " + txt} onClick={() => setSelectId(true)}>
        <div >{props.item.serviceName}</div>
        <div>||</div>
        <div>Status: {props.item.statusCode}</div>
        <div>||</div>
        <div> {props.item.timestamp}</div>
        </section>
        </>
    )
    return(
        <>
        <section className={"flex flex-wrap gap-2 rounded-md p-1 ml-2 mr-2 font-bold " + txt} onClick={() => setSelectId(false)}>
        <div >{props.item.serviceName}</div>
        <div>||</div>
        <div>Status: {props.item.statusCode}</div>
        <div>||</div>
        <div> {props.item.timestamp}</div>
        <div>|| Message: {props.item.message} || Id: {props.item.id}</div>
        </section>
        </>
    )
}


type prop = {
    item : logDataItem
}