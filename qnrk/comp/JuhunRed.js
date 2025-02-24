import React from "react";

const JuhunRed = ({ vv, key }) => {
  console.log(vv);
  const { fn} = vv;

  return (
    <div>
      <button
        onClick={() => fn("갈증")}> 눌러라,{idx}
        
      </button>
    </div>
  );
};

export default JuhunRed;
