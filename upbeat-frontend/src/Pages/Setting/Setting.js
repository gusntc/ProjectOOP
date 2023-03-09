import "./Setting.css";
import { useState , useEffect} from "react";


function Setting() {
  const [Time, setTime] = useState("30");
  const [Budget, setBudget] = useState("10");
  const [reset , setReset] = useState(false);
  console.log(Time);
  console.log(Budget);
  useEffect
  return (
    <div className="bg">
      <h1 className="title">SETTING GAME</h1>
      <div className="underline"></div>
      <div>
        <div className="defaultSetting" >Defualt setting</div>
        <table>
          <tbody>
            <tr>
              <td className="textHead">
                <p>TIME LIMITED :</p>
              </td>
              <td className="backtd">
                <div className="timeLimited">
                  <label className={Time === "15" ? "labelTime" : ""}>
                    15 minutes
                    <input
                      type="radio"
                      value="15"
                      name="time"
                      onChange={(e) => setTime(e.target.value)}
                    />
                  </label>
                  <label className={Time === "30" ? "labelTime" : ""}>
                    30 minutes
                    <input
                      type="radio"
                      value="30"
                      name="time"
                      defaultChecked={true}
                      onChange={(e) => setTime(e.target.value)}
                    />
                  </label>
                  <label className={Time === "60" ? "labelTime" : ""}>
                    60 minutes
                    <input
                      type="radio"
                      value="60"
                      name="time"
                      onChange={(e) => setTime(e.target.value)}
                    />
                  </label>
                  <label className={Time === "Unlimited" ? "labelTime" : ""}>
                    Unlimited
                    <input
                      type="radio"
                      value="Unlimited"
                      name="time"
                      onChange={(e) => setTime(e.target.value)}
                    />
                  </label>
                </div>
              </td>
            </tr>
            <tr>
              <td className="textHead">
                <p>PLAY SPACE :</p>
              </td>
              <td className="backtd">
                <div className="Playspace">
                  <label className="row">
                    <p>ROW </p>
                    <select name="selectRow" className="select1">
                      <option value="5">5</option>
                      <option value="10">10</option>
                      <option value="15">15</option>
                    </select>
                  </label>
                  <label className="column">
                    <p>SELECT</p>
                    <select name="selectColumn" className="select1">
                      <option value="5">5</option>
                      <option value="10">10</option>
                      <option value="15">15</option>
                    </select>
                  </label>
                </div>
              </td>
            </tr>
            <tr>
              <td className="textHead">
                <p>BUDGET :</p>
              </td>
              <td className="backtd">
                <div className="timeLimited">
                  <label className={Budget === "15" ? "labelBudget" : ""}>
                    15 coins
                    <input
                      type="radio"
                      value="15"
                      name="Budget"
                      onChange={(e) => setBudget(e.target.value)}
                    />
                  </label>
                  <label className={Budget === "20" ? "labelBudget" : ""}>
                    20 coins
                    <input
                      type="radio"
                      value="20"
                      name="Budget"
                      defaultChecked={true}
                      onChange={(e) => setBudget(e.target.value)}
                    />
                  </label>
                  <label className={Budget === "25" ? "labelBudget" : ""}>
                    25 coins
                    <input
                      type="radio"
                      value="25"
                      name="Budget"
                      onChange={(e) => setBudget(e.target.value)}
                    />
                  </label>
                  <label className={Budget === "30" ? "labelBudget" : ""}>
                    30 coins
                    <input
                      type="radio"
                      value="30"
                      name="Budget"
                      onChange={(e) => setBudget(e.target.value)}
                    />
                  </label>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>

      <div className="confirm">CONFIRM</div>
    </div>
  );
}

export default Setting;
