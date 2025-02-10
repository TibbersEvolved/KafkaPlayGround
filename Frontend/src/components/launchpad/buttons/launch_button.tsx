
export default function Launch_button (props: prop) {

    return (
        <>
        <button className="btn-neutral border-2 rounded-md p-1 hover:bg-amber-200">
            {props.name}
        </button>
        </>
    )
}


type prop = {
    name : string
}