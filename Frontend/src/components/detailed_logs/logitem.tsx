const code200 = ""
const code400 = ""

export default function Logitem(props : prop) {
    let txt = "bg-amber-100"
    if(props.code === 200)
        {
            txt = "bg-green-400"
        }
    if(props.code === 400)
        {
            txt = "bg-red-400"
        }
    return (
        <>
        <section className={"flex gap-2 rounded-md p-1 " + txt}>
        <div >{props.name}</div>
        <div>||</div>
        <div>Status: {props.code}</div>
        </section>
        </>
    )
}


type prop = {
    name : string,
    code : number
}