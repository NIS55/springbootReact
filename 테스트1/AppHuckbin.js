import "./App.css";
import HyuckBin from "./comp/HyuckBin";

function App() {
  const ff = (i) => {
    console.log("버튼이 눌렸습니다..");
    return i + 3;
  };
  // 23이랑 객체 들어있음
  // 객체 키값 a 데이터값[1,2,3,4]
  // const fv = (i, { a }) => {
  //   return ", " + i + " " + a;
  // };

  const rr = ({ a }) => {
    console.log(a);

    var oddCnt = 0;
    var evenCnt = 0;

    for (var i of a) {
      if (i % 2 == 0) evenCnt++;
      else oddCnt++;
    }
    return { oddCnt, evenCnt };
  };
  // return <HyuckBin fu={ff} vu={(i, j) => i + rr(j).oddCnt}></HyuckBin>;
  return <HyuckBin fu={ff} vu={(i, j) => i + rr(j).oddCnt}></HyuckBin>;
}

export default App;
