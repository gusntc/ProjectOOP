import React, { useState, useEffect } from "react";
import "./Profile.css";
import { AnimatePresence, motion } from "framer-motion";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faUser, faWallet , faSackDollar } from "@fortawesome/free-solid-svg-icons";

function Profile() {
  const [profile, setProfile] = useState();
  const [check, setCheck] = useState(false);
  const [show, setShow] = useState(false);
  let name = "Player123";
  let budget = 0;
  let allBudget = 0;
  useEffect(() => {
    const fetchData = async () => {
      // eslint-disable-next-line
      const response = await fetch(`http://localhost:8080/api/profile`)
        .then((response) => response.json())
        .then((result) => {
          setProfile(result);
          setCheck(true);
        })
        .catch((err) => console.log(err));
      //   const newData = await response.json();
      //   setProfile(newData);
    };
    fetchData();
  }, []);

  if (check) {
    name = profile[0].name;
    budget = profile[0].budget;
    allBudget = profile[0].allBudget;
  }

  const showUI = () => {
    setShow(true);
  };
  const hideUI = () => {
    setShow(false);
  };

  return (
    <>
      <div onClick={showUI} className="profile">
        <FontAwesomeIcon
          icon={faUser}
          style={{
            margin: 15,
            fontSize: 15,
          }}
        />
        <p>My Profile</p>
      </div>
      <AnimatePresence mode="wait">
      {show && (
        <div>
          <motion.div
            className="PlayerData"
            variants={StartUI}
            initial="In"
            animate="Visible"
            exit="Out"
            transition={{
              duration: 0.25,
              ease: "easeInOut",
            }}
            key={name}
          >
            <motion.h2
              className="playerName"
              variants={TextInOut}
              custom={1}
              initial="TextIn"
              animate="visible"
            >
              {name}
            </motion.h2>
            <div className="x" onClick={hideUI}></div>
            <motion.div className="info">
              <motion.p
                variants={TextInOut}
                custom={2}
                initial="TextIn"
                animate="visible"
              >
                {/* Icon */}
                <FontAwesomeIcon
                  icon={faWallet}
                  style={{
                    margin: 0,
                    fontSize: 15,
                  }}
                />
                <span>{budget}</span>
              </motion.p>
              <motion.p
                variants={TextInOut}
                custom={3}
                initial="TextIn"
                animate="visible"
              >
                {/* icon */}
                <FontAwesomeIcon
                  icon={faSackDollar}
                  style={{
                    margin: 0,
                    fontSize: 15,
                  }}
                />
                <span>{allBudget}</span>
              </motion.p>
            </motion.div>
          </motion.div>
        </div>
      )}
      </AnimatePresence>
    </>
  );
}

export default Profile;

const StartUI = {
  In: { opacity: 0, transform: `translate(-50% , -100px)` },
  Out: {
    opacity: 0,
    transform: `translateX(-50%) translateY(-100px)`,
    transition: {
      duration: 0.3,
    },
  },
  Visible: {
    opacity: 1,
    transform: `translate(-50% , 0px)`,
    transition: {
      duration: 0.5,
      ease: "easeInOut",
    },
  },
};

const TextInOut = {
  TextIn: { x: -50, opacity: 0 },
  visible: (i) => ({
    x: 0,
    opacity: 1,
    transition: {
      duration: 0.5,
      ease: "easeInOut",
      delay: i * 0.1,
    },
  }),
};
