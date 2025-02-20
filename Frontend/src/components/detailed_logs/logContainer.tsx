import { useQuery } from "@tanstack/react-query";
import { fetchLogItems } from "./fetchCalls";
import Logitem from "./logitem";
import LogSelectService from "./logSelectService";

export default function LogContainer() {
    const { data, isLoading, isError } = useQuery({
        queryKey: ["loadLogs"],
        queryFn: () => fetchLogItems()
      });

      if (isLoading)
        return <div>Loading...</div>;
      if (isError) return <div>Server Error</div>;
      const array : logDataItem[] = data;

      return (
        <>
        <section>
          <header className="flex gap-5 mb-2 p-2 border-solid border-sky-900 border-2 bg-slate-100 rounded-md shadow-sm">
        <div>Filter:</div>
        <LogSelectService/>
        </header>
        <div className="flex flex-col gap-2 border-2 border-b-blue-950 p-4 rounded-md shadow-sm bg-slate-100">
          {array.map((res, key) => {
            return <Logitem item={res} key={key}/>
          })}      
        </div>
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