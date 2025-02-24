import React from "react";

const Yunjae = () => {
  return (
    <div>
      {[
        { fn: (i) => alert(i + "사랑") },
        { fn: (i) => alert(i + "믿음") },
        { fn: (i) => alert(i + "증오") },
        { fn: (i) => alert(i + "폭발") },
        { fn: (i) => alert(i + "멸망") },
      ].map((i, idx) => (
        <JuheonRed key={idx} dd={i} vv={idx} />
      ))}
    </div>
  );
};

export default Yunjae;
