import React, { useState } from "react";
import Bun from "./Bun";
import Display from "./Display";

const initialData = [1, 2, 3, 4, 5].map(no => ({
  studentNo: no,
  math: 0,
  eng: 0,
  korea: 0,
  total: 0,
  avg: 0,
  grade: ""
}));

const Ban = () => {
  const [data, setData] = useState(initialData);


  const calcGrade = (avg) => {
    if (avg >= 90) return "A";
    if (avg >= 80) return "B";
    if (avg >= 70) return "C";
    if (avg >= 60) return "D";
    return "F";
  };


  const handler = (no, newData) => {
    setData(prevData =>
      prevData.map(student => {
        if (student.studentNo === no) {
          const updatedStudent = {
            ...student,
            ...newData,
          };

          const math = updatedStudent.math || 0;
          const eng = updatedStudent.eng || 0;
          const korea = updatedStudent.korea || 0;
          updatedStudent.total = math + eng + korea;
          updatedStudent.avg = updatedStudent.total / 3;
          updatedStudent.grade = calcGrade(updatedStudent.avg);
          return updatedStudent;
        }
        return student;
      })
    );
  };

  return (
    <div>
      {data.map(student => (
        <div key={student.studentNo}>
          <Bun no={student.studentNo} v={handler} calcGrade={calcGrade} />
        </div>
      ))}
      <Display data={data} />
    </div>
  );
};

export default Ban;
