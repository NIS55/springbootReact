import React from "react";

const HyuckBin = ({ fu, vu }) => {
  return (
    <div>
      HyuckBin
      <br />
      <button
        onClick={() => {
          console.log(fu(44) + vu(23, { a: [1, 2, 3, 4] }));
        }}
      >
        눌러라
      </button>
    </div>
  );
};

export default HyuckBin;
