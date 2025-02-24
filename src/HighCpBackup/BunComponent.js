import React from "react";

const BunComponent = ({ student, index, onChange }) => {
  if (!student) {
    return <p>학생 정보가 없습니다.</p>; // student가 없을 때 처리
  }

  const handleInputChange = (field, e) => {
    onChange(index, field, e.target.value);
  };

  return (
    <div>
      <h3>{student.name}</h3>
      <div>
        <label>국어:</label>
        <input
          type="number"
          value={student.korea}
          onChange={(e) => handleInputChange("korea", e)}
        />
      </div>
      <div>
        <label>영어:</label>
        <input
          type="number"
          value={student.eng}
          onChange={(e) => handleInputChange("eng", e)}
        />
      </div>
      <div>
        <label>수학:</label>
        <input
          type="number"
          value={student.math}
          onChange={(e) => handleInputChange("math", e)}
        />
      </div>
      <div>
        <p>총점: {student.total}</p>
        <p>평균: {student.avg}</p>
        <p>등급: {student.grade}</p>
      </div>
      <hr />
    </div>
  );
};

export default BunComponent;
