import "./Hexagon.css";
import hexagon from "./Untitled.png";
function SingleHexagon({ onClick, namespace }) {
  // const i = 1;
  return (
    <img
      src={hexagon}
      alt="hex"
      className="hex"
      onClick={onClick}
      key={namespace}
      draggable="false"
    ></img>
  );
}
export default SingleHexagon;
