import { useQuery } from "@tanstack/react-query";
import { fetchLogItems } from "./fetchCalls";
import Logitem from "./logitem";

export default function LogContainer() {
    const { data, isLoading, isError } = useQuery({
        queryKey: ["loadLogs"],
        queryFn: () => fetchLogItems()
      });

      if (isLoading)
        return <div>Loading...</div>;
      if (isError) return <div>Server Error</div>;
      console.log(data);
      const array : logDataItem[] = data;

      return (
        <>
        <div>Results:</div>
        <div className="flex flex-col gap-2">
          {array.map((res, key) => {
            return <Logitem item={res} key={key}/>
          })}      
        </div>
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