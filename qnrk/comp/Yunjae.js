import React from "react";
import JuhunRed from "./JuhunRed";

export const Yunjae = () => {
  return (
    <div>
      {[
        { fn :(i) => alert(i + "사랑,")},
        { fn :(i) => alert(i + "믿음,")},
        { fn :(i) => alert(i + "증오,")},
        { fn :(i) => alert(i + "갈증,")},
        { fn :(i) => alert(i + "배신,")},
      ].map((i, idx) => (
        <JuhunRed key={idx} vv={i} idx={idx} />
      ))}
    </div>
  );
};

export default Yunjae;
