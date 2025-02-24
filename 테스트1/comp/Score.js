import React, { useState } from "react";

const Score = () => {
  const [a, setA] = useState([
    { no: 1, math: 30, eng: 50 },
    { no: 2, math: 35, eng: 70 },
    { no: 3, math: 37, eng: 100 },
    { no: 4, math: 80, eng: 90 },
  ]);
  const upDate = () => {
    setA((j) =>
      a.map((i) => {
        if (i.no === 2) {
          console.log("확인 : ", i);
          var tt = { ...i, ...{ v: 77 } };
        } else {
          tt = i;
        }
        return tt;
      })
    );
  };

  return (
    <div>
      <div>
        <button onClick={upDate}>변경</button>
        {a.map((i) => (
          <div key={i.no}>
            {i.no},{i.math},{i.v}
          </div>
        ))}
      </div>
    </div>
  );
};

export default Score;
