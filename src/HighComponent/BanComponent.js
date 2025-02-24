/*
5개의 반을 만들어 5명 각각의 데이터 값 생성
국어 : korea / 영어 : eng / 수학 : math
는 직접 입력하고 총점과 평균 등급은 자동으로
계산하여 처리하게 프로그래밍 한다.
리엑트를 이용하여 제작한다
  
반 = class : BanComponent.js 
분 = student : BunComponent.js
App.js // App.css 포함
코드 파일은 위와 같이 제작한다.

// header : High 학교 학생 성적 관리 
// 학생 정보 가로로 5명 정렬 ui
// 학생 한명당 박스 폼 안에 수학/영어/국어
// 점수 입력 칸 생성
// 그리고 점수 입력 칸 아래 평균 총점 표시 칸 생성
// 배경에 high 학교 이미지 삽입할 수 있게 ui 생성
// https://www.starbucks.co.kr/menu/drink_list.do 
// 해당 사이트 UI 참고해서 만들어줘


*/

import React from "react";
import BunComponent from "./BunComponent";

function BanComponent({ students, onScoreChange }) {
  return (
    <div className="BanComponent">
      {students.map((student) => (
        <BunComponent
          key={student.id}
          student={student}
          onScoreChange={onScoreChange}
        />
      ))}
    </div>
  );
}

export default BanComponent;
