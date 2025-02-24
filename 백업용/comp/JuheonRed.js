import React from "react";

// const JuheonRed = ({ vv, key }) => {
//   return <div>JuheonRed : {vv}</div>;
// };
const JuheonRed = ({ dd, vv }) => {
  console.log(dd);
  const { fn } = dd;
  return (
    <div>
      {/* <button
        onClick={() => {
          vv + dd(vv);
        }}
      >
        눌러 ! {vv}
      </button> */}

      <button onClick={() => fn("갈증")}>눌러,{vv} !</button>
    </div>
  );
};

export default JuheonRed;
