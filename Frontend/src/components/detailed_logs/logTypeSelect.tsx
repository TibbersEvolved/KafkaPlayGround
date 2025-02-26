export default function LogTypeSelect() {

    return(<>
          <select name="service" className="border-2 border-solid border-sky-900 rounded-md shadow-sm bg-amber-200"
          >
            <option value="All">All</option>
            <option value="All">OK</option>
            <option value="All">ERROR</option>
            <option value="All">WARN</option>
          </select>
    </>)
}