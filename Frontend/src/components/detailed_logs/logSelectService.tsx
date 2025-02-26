import { useQuery } from "@tanstack/react-query";
import { fetchLogItems, fetchServiceNames } from "./fetchCalls";
import { ChangeEvent } from "react";



export default function LogSelectService(prop : props) {
    const { data, isLoading, isError } = useQuery({
        queryKey: ["loadServiceNames"],
        queryFn: () => fetchServiceNames()
      });

      

      if (isLoading)
        return <div>Loading...</div>;
      if (isError) return <div>Server Error</div>;
      
      const change = (someValue : ChangeEvent<HTMLSelectElement>) => {
        const val : string = someValue.target.value
        prop.cb(val);
      }


      return (<>
      <select name="service" className="border-2 border-solid border-sky-900 rounded-md shadow-sm bg-amber-200"
      onChange={(s : ChangeEvent<HTMLSelectElement>) => change(s)}>
      <option value="All">All</option>
      {
        data.services.map((res : string, key : number) => {
            return <option key={key} value={res}>{res}</option>
        })
      }
      </select>
      </>)
}

type props = {
  cb : (s : string) => void
}
