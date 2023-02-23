import SingleHexagon from "./Hexagon/SingleHexagon";
import React, { useState, useEffect } from "react";
import { useRef } from "react";
import "./map.css";
import { AnimatePresence, motion } from "framer-motion";
import RegionData from "../RegionData/RegionData";

function Map() {
  const [data, setData] = useState(null);
  const [check, setCheck] = useState(false);
  const [show, setShow] = useState(false);
  const constraintsRef = useRef(null);
  useEffect(() => {
    const fetchData = async () => {
      // eslint-disable-next-line
      const response = await fetch(`http://localhost:8080/api/hex2`)
        .then((response) => response.json())
        .then((result) => {
          setData(result);
          setCheck(true);
        })
        .catch((err) => console.log(err));
      //   const newData = await response.json();
      //   setProfile(newData);
    };
    fetchData();
  }, []);
  if (check) {
    console.log(data);
  }

  const showUI = () => {
    setShow(true);
  };
  const hideUI = () => {
    setShow(false);
  };

  return (
    <>
      <motion.div className="container" ref={constraintsRef}>
        <motion.div
          drag
          className="Map"
          dragConstraints={constraintsRef}
        >
          <div style={{ display: "flex" }}>
            {data &&
              data[0].map((item, indexColumn) => {
                return (
                  <div
                    key={"row" + indexColumn}
                    style={{
                      width: 200 - 200 / 4 + 3.5,
                    }}
                    className={indexColumn % 2 === 0 ? "oddHex" : "evenHex"}
                  >
                    {data.map((rowitem, indexRow) => {
                      return (
                        <SingleHexagon
                          namespace={`${indexColumn}` + `${indexRow}`}
                          key={`${indexColumn}` + `${indexRow}`}
                          // onClick={console.log(`${indexColumn}`+":"+`${indexRow}`)}
                          onClick={showUI}
                        />
                        // <div>({arr[indexRow][indexColumn]})</div>
                      );
                    })}
                  </div>
                );
              })}
          </div>
        </motion.div>
      </motion.div>
      {
        show && (
          <motion.div className="RegionData">
            <RegionData/>
            <div className="x"onClick={hideUI} ></div>
          </motion.div>
        )
      }
    </>
  );
}

export default Map;

//   const arr = [
//     [0,1,2,3,4,5,6,7,8],
//     [0,1,2,3,4,5,6,7,8],
//     [0,1,2,3,4,5,6,7,8],
//     [0,1,2,3,4,5,6,7,8]
//   ];
