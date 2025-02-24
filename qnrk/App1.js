import React, { useState } from "react";
import BanComponent from "./HighComponent/BanComponent";
import "./App.css"; // CSS 파일 임포트

function App() {
  const initialData = [
    {
      id: 1,
      name: "학생1",
      korea: "",
      eng: "",
      math: "",
      total: 0,
      average: 0,
      grade: "",
    },
    {
      id: 2,
      name: "학생2",
      korea: "",
      eng: "",
      math: "",
      total: 0,
      average: 0,
      grade: "",
    },
    {
      id: 3,
      name: "학생3",
      korea: "",
      eng: "",
      math: "",
      total: 0,
      average: 0,
      grade: "",
    },
    {
      id: 4,
      name: "학생4",
      korea: "",
      eng: "",
      math: "",
      total: 0,
      average: 0,
      grade: "",
    },
    {
      id: 5,
      name: "학생5",
      korea: "",
      eng: "",
      math: "",
      total: 0,
      average: 0,
      grade: "",
    },
  ];

  const [students, setStudents] = useState(initialData);

  // 성적 계산 함수
  const calculateScore = (id, subject, value) => {
    const updatedStudents = students.map((student) => {
      if (student.id === id) {
        student[subject] = value;
        student.total =
          parseInt(student.korea || 0) +
          parseInt(student.eng || 0) +
          parseInt(student.math || 0);
        student.average = student.total / 3;
        student.grade =
          student.average >= 90
            ? "A"
            : student.average >= 80
            ? "B"
            : student.average >= 70
            ? "C"
            : "F";
      }
      return student;
    });

    setStudents(updatedStudents);
  };

  return (
    <div className="App">
      <h2>High 학교 학생 성적 관리</h2>
      <BanComponent students={students} onScoreChange={calculateScore} />
    </div>
  );
}

export default App;
