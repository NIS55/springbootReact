import React, { useState } from "react";

const JongGunTeamLeader = () => {
  const [data, setData] = useState({ math: 0, eng: 0 });

  const onChangeHandler = (e) => {
    setData({ ...data, [e.target.name]: e.target.value });
  };
  return (
    <div>
      {/* <div>
        <input
          type="text"
          style={{ border: "solid" }}
          onChange={() => setData(data + 5)}
          value={data}
        ></input>
      </div> */}

      <div>
        수학
        <input
          type="text"
          style={{ border: "solid" }}
          onChange={onChangeHandler}
          value={data.math}
          name="math"
        ></input>
      </div>
      <div>
        영어
        <input
          type="text"
          style={{ border: "solid" }}
          onChange={onChangeHandler}
          value={data.eng}
          name="eng"
        ></input>
      </div>
      <p>
        {data.math},{data.eng}
      </p>
    </div>
  );
};

export default JongGunTeamLeader;
