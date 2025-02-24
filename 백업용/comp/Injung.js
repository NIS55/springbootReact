import React, { useState } from "react";

const Injung = () => {
  const [cnt, setCnt] = useState(10);
  const increase = () => setCnt(cnt + 1);
  const decrease = () => setCnt(cnt - 1);

  return (
    <div>
      <div>
        <button onClick={increase} style={{ color: "red", border: "solid" }}>
          + 더하기
        </button>
      </div>
      <div>
        <button onClick={decrease} style={{ color: "blue", border: "solid" }}>
          - 빼기
        </button>
      </div>
      <div>{cnt}</div>
    </div>
  );
};

export default Injung;
