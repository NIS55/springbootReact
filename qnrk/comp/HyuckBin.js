import React from "react";

export const HyuckBin = ({fu,vv}) => {
  return (
    <div>
      HyuckBin
      <button onClick={() => {
        console.log("결과" , fu(34)+vv(23,{"a":[1,2,3,4]}));
        // HyuckBin = fu,vv
        // fu = 34 / vv = 23 , 객체의 키값 a에 배열 데이터 값인 1234
        // 버튼을 누르면 함수가 출력...?
    }}
    >  
        눌러라
        </button>
    </div>
  );
};

export default HyuckBin;
