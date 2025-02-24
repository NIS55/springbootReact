import axios from "axios";
import React, { useEffect, useState } from "react";

const GreenPrj = ({ v }) => {
  const [data, setData] = useState([]);
  const [page, setPage] = useState(0);
  const [size, setSize] = useState(0);
  return (
    <div>
      Prj,{v}
      {data.pname}
      <div>
        현재 페이지
        <input
          type="text"
          name="page"
          onChange={(e) => setPage(e.target.value)}
          value={page}
        />
      </div>
      <div>
        페이지당 데이터의 갯수
        <input
          type="text"
          name="size"
          onChange={(e) => setSize(e.target.value)}
          value={size}
        />
      </div>
      <button
        onClick={() => {
          const f = async () => {
            const res = await axios.get(
              `http://localhost:8080/api/products/list?size=${size}&page=${page}`
            );
            console.log(res.data);
            setData(res.data);
          };

          f();
        }}
      >
        확인
      </button>
      <div>
        {data.dtoList &&
          data.dtoList.map((i) => (
            <div key={i.pno}>
              {i.pname},{i.pdesc},{i.price}
            </div>
          ))}
      </div>
    </div>
  );
};

export default GreenPrj;

// import axios from "axios";
// import React, { useEffect, useState } from "react";

// export const Prj = ({ v }) => {
//   const [data, setData] = useState({});
//   const [page, setPage] = useState(0);
//   const [size, setSize] = useState(0);

//   // 데이터 가져오기 함수
//   const f = async () => {
//     try {
//       const res = await axios.get(
//         "http://localhost:8080/api/products/list?size=12&page=1"
//       );

//       console.log(res.data);
//       setData(res.data); // 받아온 데이터 저장
//     } catch (error) {
//       console.error("데이터 가져오기 실패 : ", error);
//     }
//   };

//   //처음 렌더링될 때 레이터 로드
//   useEffect(() => {
//     f();
//   }, []);

//   return (
//     <div>
//       <h2>Prj.{v}</h2>

//       {/* 데이터 목록 출력 */}
//       <ul>
//         {data.map((item, index) => (
//           <li key={index}>{item.pname}</li>
//         ))}
//       </ul>

//       {/* 페이지 입력 */}
//       <div>
//         <label>현재 페이지 : </label>
//         <input
//           type="text"
//           value={page}
//           min="1"
//           onChange={(e) => setPage(Number(e.target.value))}
//           onKeyDown={(e) => e.key === "Enter" && f()}
//           //Enter 입력 시 실행
//         />
//       </div>

//       {/* 페이지당 데이터 개수 입력 */}
//       <div>
//         <label>페이지당 데이터 개수 :</label>
//         <input
//           type="text"
//           value={size}
//           min="1"
//           onChange={(e) => setPage(Number(e.target.value))}
//           onKeyDown={(e) => e.key === "Enter" && f()}
//           //Enter 입력 시 실행
//         />
//       </div>

//       {/* 데이터 로드 버튼 */}
//       <button onClick={f}>확인</button>
//     </div>
//   );
// };

// //product 전체 목록 출력
// //http://localhost:8080/api//product/list?size=12&page=3
// export const GreenPrj = (props) => <Prj {...props} />;

// export default GreenPrj;
