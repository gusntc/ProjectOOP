import "./Login.css";
import { useState } from "react";
function Login() {
  const [playername, setPlayername] = useState("");
  const [ready, setReady] = useState("READY");
  const num = 1;
  const flipReady = () => {
    if (ready === "READY") {
      setReady("UNREADY");
    } else if (ready === "UNREADY") {
      setReady("READY");
    }
  };
  return (
    <div className="bg">
      <h1 className="title">PLAYER {num}</h1>
      <div className="underline"></div>

      <div className="inputline">
        <div className="name">NAME:</div>
        <input
          value={playername}
          onChange={(e) => setPlayername(e.target.value)}
          placeholder="Please input player name"
          className="input"
        />
      </div>
      <div className="btn">
        <div
          className={ready === "READY" ? "ready" : "unready"}
          onClick={flipReady}
        >
          {ready}
        </div>
        <div className={ready === "READY" ? "waiting-none" : "waiting"}>
        waiting for other player
      </div>
      </div>
      
    </div>
  );
}

export default Login;
