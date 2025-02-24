import React from "react";
import JuheonRed from "../comp/JuheonRed";

const Juheon = () => {
  return (
    <div>
      {/* {["사랑", 22, 33, 44].map((i, idx) => (
        <JuheonRed key={idx} vv={i} /> 
      ))} */}

      {[
        (i) => alert(i + "사랑"),
        (i) => alert(i + "믿음"),
        (i) => alert(i + "증오"),
        (i) => alert(i + "갈증"),
        (i) => alert(i + "멸망"),
      ].map((i, idx) => (
        <JuheonRed key={idx} vv={idx} dd={i} />
      ))}
    </div>
  );
};

export default Juheon;
