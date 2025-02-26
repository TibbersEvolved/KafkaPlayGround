import { useQuery } from "@tanstack/react-query";
import { fetchLogItems } from "./fetchCalls";
import { logDataItem } from "./logContainer";
import Logitem from "./logitem";

export default function LogList(prop : props) {
    console.log("Id Filter: " + prop.logFilter)
    const { data, isLoading, isError } = useQuery({
        queryKey: ["loadLogList", prop.logFilter],
        queryFn: () => fetchLogItems(prop.logFilter)
      });

            if (isLoading)
              return <div>Loading...</div>;
            if (isError) return <div>Server Error</div>;
            const array : logDataItem[] = data;

        return (        
            <div className="flex flex-col gap-2 border-2 border-b-blue-950 p-4 rounded-md shadow-sm bg-slate-100">
                  {array.map((res, key) => {
                    return <Logitem item={res} key={key}/>
                  })}      
            </div>)
}

type props = {
    logFilter : string
}