import Service from "./service";

export default function Healthcare() {
    return (
        <>
        <section className="border-sky-900 border-2 pb-10 ml-4 mr-4 mt-3 rounded-md">
        <div className="flex justify-center">
        <header className="mb-5 text-2xl">App Health</header>
        </div>
        <section className="flex ml-6 mr-6 justify-center gap-6">
            <Service name="AutoPod"/>
            <Service name="Dark Web"/>
            <Service name="Greeter"/>
            <Service name="Math Service"/>
        </section>
        </section>
        </>
    )
}