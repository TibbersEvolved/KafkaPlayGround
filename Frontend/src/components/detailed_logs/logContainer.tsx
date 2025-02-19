import { useQuery } from "@tanstack/react-query";
import { fetchLogItems } from "./fetchCalls";

export default function LogContainer() {
    const { data, isLoading, isError } = useQuery({
        queryKey: ["loadLogs"],
        queryFn: () => fetchLogItems()
      });

      if (isLoading)
        return <div>Loading...</div>;
      if (isError) return <div>Server Error</div>;

      return (
        <>
        <div>Results:</div>
        <div></div>
        </>
      )
}