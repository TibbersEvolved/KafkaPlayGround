export default function Service(props : prop) {
return (
    <>
    <div className="bg-green-500 border-2 rounded-sm shadow-md p-2">{props.name}</div>
    </>
)
}

type prop = {
    name : string
}