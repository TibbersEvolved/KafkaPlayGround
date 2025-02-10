import Logitem from "./logitem";

export default function Logui() {
    return (
        <>
        <section>
            <div className="flex flex-col gap-2">
                <Logitem name="Request1" code={200}/>
                <Logitem name="Request2" code={400}/>
                <Logitem name="Request3" code={0}/>
            </div>
        </section>
        </>
    )
}