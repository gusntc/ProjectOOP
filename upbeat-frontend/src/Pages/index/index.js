import { NavLink } from "react-router-dom";
import "./home.css";

function index() {
  return (
    <div>
      <h1 className="title">UPBEAT</h1>
      <div className="underline"></div>
      <div className="allBTN">
        <NavLink to="Login" className="BTN btn1">
          START
        </NavLink>
        <NavLink to="HowToPlay" className="BTN btn2">
          HOW TO PLAY
        </NavLink>
      </div>
    </div>
  );
}

export default index;
