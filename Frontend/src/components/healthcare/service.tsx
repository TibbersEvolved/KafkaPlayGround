import { useQuery } from "@tanstack/react-query";
import { pingHealth } from "./fetchCalls";
import UtilityLoader from "../utility/utilityLoader";
import UtilityOk from "../utility/utilityOk";
import UtilityBad from "../utility/utilityBad";

export default function Service(props : prop) {
    const { data, isLoading, isError } = useQuery({
        queryKey: ["ping_" + props.url],
        queryFn: () => pingHealth(props.url)
      });
      if (isLoading)
        return <div className="bg-amber-100 border-2 rounded-sm shadow-md p-2 flex flex-row">
          <div>{props.name}</div>
          <UtilityLoader/>
        </div>;
      if (isError) return <div className="bg-red-400 border-2 rounded-sm shadow-md p-2 flex flex-row">
                  <div>{props.name}</div>
                  <UtilityBad/>
                  </div>;

return (
    <>
    <div className="bg-green-400 border-2 rounded-sm shadow-md p-2 flex flex-row">
      <div>{props.name}</div>
      <UtilityOk/>
      </div>
    </>
)
}

type prop = {
    name : string
    url : string
}