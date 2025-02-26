import { useQuery } from "@tanstack/react-query";
import { fetchLogItems } from "./fetchCalls";
import Logitem from "./logitem";
import LogSelectService from "./logSelectService";
import { useState } from "react";
import LogList from "./logList";
import LogDateSelect from "./logDateSelect";
import LogTypeSelect from "./logTypeSelect";

export default function LogContainer() {
    const [select, setSelect] = useState("All");

      

      return (
        <>
        <section>
          <header className="flex gap-2 mb-2 p-2 border-solid border-sky-900 border-2 bg-slate-100 rounded-md shadow-sm">
        <div className="font-extrabold">Filters |</div>
        <div>Service:</div>

        <LogSelectService cb={ (s) => setSelect(s)}/>
          <div>Date:</div>
          <LogDateSelect/>
          <div>Type:</div>
          <LogTypeSelect/>
        </header>
        <LogList logFilter={select}/>
        </section>
        </>
      )
}



export type logDataItem  = {
id : string,
message: string,
serviceName : string,
statusCode : number,
timestamp : string
}