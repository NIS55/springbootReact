import React, { useState } from "react";

const JongGunTeamLeader = () => {
  const [data, setData] = useState({ vip: "", sreader: "" });
  const onChangeHandler = (e) => {
    setData({ ...data, [e.target.name]: e.target.value });
  };

  return (
    <div>
      <div>
        국가원수 김종건
        <input
          style={{ border: "solid" }}
          type="text"
          onChange={onChangeHandler}
          value={data.vip}
          name="vip"
        />
      </div>
      <div>
        분대장 김종건
        <input
          style={{ border: "solid" }}
          type="text"
          onChange={onChangeHandler}
          value={data.sreader}
          name="sreader"
        />
      </div>
      <p></p>
    </div>
  );
};

export default JongGunTeamLeader;
