import { useState } from "react";
import Healthcare from "../healthcare/healthcare";
import LogContainer from "./logContainer";
import Logitem from "./logitem";

export default function Logui() {
    

    return (
        <>
        <section className="flex flex-col gap-12">
            <Healthcare/>
            <LogContainer/>
        </section>
        </>
    )
}