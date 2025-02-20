import { useQuery } from "@tanstack/react-query";
import { fetchLogItems, fetchServiceNames } from "./fetchCalls";



export default function LogSelectService() {
    const { data, isLoading, isError } = useQuery({
        queryKey: ["loadServiceNames"],
        queryFn: () => fetchServiceNames()
      });

      if (isLoading)
        return <div>Loading...</div>;
      if (isError) return <div>Server Error</div>;
      console.log(data)
      return (<>
      <select name="service" className="border-2 border-solid border-sky-900">
      <option value="all">All</option>
      {
        data.services.map((res : string, key : number) => {
            return <option key={key} value={res}>{res}</option>
        })
      }
      </select>
      </>)
}
