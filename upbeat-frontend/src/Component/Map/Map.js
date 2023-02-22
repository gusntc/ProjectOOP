import SingleHexagon from "./Hexagon/SingleHexagon";
import React, { useState, useEffect } from "react";
import "./map.css";

function Map() {
  const [data, setData] = useState(null);
  const [check, setCheck] = useState(false);
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

  console.log(data);

  return (
    <div style={{ display: "flex", transform: "scale(1)" }}>
      {data &&
        data[0].map((item, indexColumn) => {
          return (
            <div
              key={"row" + indexColumn}
              style={{
                width: 200 - 200 / 4 + 3,
              }}
              className={indexColumn % 2 == 0 ? "oddHex" : "evenHex"}
            >
              {data.map((rowitem, indexRow) => {
                return (
                  <SingleHexagon
                    onClick={() => {
                      alert(indexColumn);
                    }}
                    namespace={`${indexColumn}` + `${indexRow}`}
                    key={`${indexColumn}` + `${indexRow}`}
                  />
                  // <div>({arr[indexRow][indexColumn]})</div>
                );
              })}
            </div>
          );
        })}
    </div>
  );
}

export default Map;

//   const arr = [
//     [0,1,2,3,4,5,6,7,8],
//     [0,1,2,3,4,5,6,7,8],
//     [0,1,2,3,4,5,6,7,8],
//     [0,1,2,3,4,5,6,7,8]
//   ];
