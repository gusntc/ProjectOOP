import { LayoutGroup, motion } from "framer-motion";
import "./App.css";
import { useRef } from "react";
import Profile from "./Component/Profile/Profile";
// import SingleHexagon from "./Component/Map/Hexagon/SingleHexagon";
import Map from "./Component/Map/Map";

function App() {
  const constraintsRef = useRef(null);
  return (
    <>
      <LayoutGroup>
        <motion.div className="container" ref={constraintsRef}>
          <motion.div className="item" drag dragConstraints={constraintsRef} />
        </motion.div>
        {/* <div className="Map">
          <Map />
        </div>

        <div className="Profile">
          <Profile />
        </div> */}
      </LayoutGroup>
    </>
  );
}

export default App;

// Where ?
