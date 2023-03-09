import { LayoutGroup, motion } from "framer-motion";
import "./App.css";
import React, { useState } from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Maingame from "./Pages/Maingame/Maingame";
import Home from "./Pages/index";
import Login from "./Pages/Login/Login";
import HowtoPlay from "./Pages/HowToPlay/HowToPlay";
import Setting from "./Pages/Setting/Setting"

function App() {
  return (
    <>
      <LayoutGroup>
        {/* Maingame page */}
        {/* <Maingame/> */}

        {/* index */}
        <Router>
          {/* <Home></Home> */}
          {/* <Routes>
          <Route exact path="/Login" element={<Login />} />
          <Route exact path="/HowToPlay" element={<HowtoPlay />} />
        </Routes> */}
        </Router>

        {/* howtoplay */}
        {/* <HowtoPlay /> */}

        {/* LOGIN */}
        {/* <Login/> */}

        {/* SETTING */}
        <Setting/>
      </LayoutGroup>
    </>
  );
}

export default App;
