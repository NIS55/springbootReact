import React, { useState } from "react";

export const Injung = () => {
  const [cnt, setCnt] = useState(10);
  const increase = () => setCnt(cnt + 1);
  const decrease = () => setCnt(cnt + 1);

  return (
    <div>
      <div>
        <button
          onClick={increase}
          style={{ color: "red", border: "soild" }}
        ></button>
      </div>
      
      <div>
        <button
          onClick={decrease}
          style={{ color: "blue", border: "soild" }}
        ></button>
      </div>
      <div>{cnt}</div>
    </div>
  );
};

export default Injung;
