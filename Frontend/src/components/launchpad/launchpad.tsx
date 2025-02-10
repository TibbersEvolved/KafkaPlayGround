import Launch_button from "./buttons/launch_button";



export default function Launchpad() {

    return (
        <>
        <div>This is the launchpad</div>
        <div className="flex gap-2">
        <Launch_button name="Button 1"></Launch_button>
        <Launch_button name="Button 2"></Launch_button>
        </div>
        </>
    )
}