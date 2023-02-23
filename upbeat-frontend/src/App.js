import { LayoutGroup, motion } from "framer-motion";
import "./App.css";
import Profile from "./Component/Profile/Profile";
import Map from "./Component/Map/Map";
import React, { useState } from "react";

function App() {
  return (
    <>
      <LayoutGroup>
        <div className="Map">
          <Map />
        </div>
        <div className="Profile">
          <Profile />
        </div>
      </LayoutGroup>
    </>
  );
}

export default App;
