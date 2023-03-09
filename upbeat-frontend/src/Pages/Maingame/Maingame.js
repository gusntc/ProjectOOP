import { LayoutGroup, motion } from "framer-motion";
import "./Maingame.css";
import Profile from "../../Component/Profile/Profile";
import Map from "../../Component/Map/Map";
import React, { useState } from "react";

function Maingame() {
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

export default Maingame;
