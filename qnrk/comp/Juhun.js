import React from "react";
import JuhunRed from "./JuhunRed";

export const Juhun = () => {
  return (
    <div>
      {[
        (i) => alert(i + "사랑,"),
        (i) => alert(i + "믿음,"),
        (i) => alert(i + "증오,"),
        (i) => alert(i + "갈증,"),
        (i) => alert(i + "배신,"),
      ].map((alf, idx) => (
        <JuhunRed key={idx} vv={alf} />
      ))}
    </div>
  );
};

export default Juhun;
