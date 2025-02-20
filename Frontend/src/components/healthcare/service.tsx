import { useQuery } from "@tanstack/react-query";
import { pingHealth } from "./fetchCalls";

export default function Service(props : prop) {
    const { data, isLoading, isError } = useQuery({
        queryKey: ["ping_" + props.url],
        queryFn: () => pingHealth(props.url)
      });
      if (isLoading)
        return <div className="bg-amber-100 border-2 rounded-sm shadow-md p-2">{props.name}</div>;
      if (isError) return <div className="bg-red-400 border-2 rounded-sm shadow-md p-2">{props.name}</div>;

return (
    <>
    <div className="bg-green-400 border-2 rounded-sm shadow-md p-2">{props.name}</div>
    </>
)
}

type prop = {
    name : string
    url : string
}