import React from "react";

function BunComponent({ student, onScoreChange }) {
  const { id, name, korea, eng, math, total, average, grade } = student;

  return (
    <div className="BunComponent">
      <h3>{name}</h3>
      <div className="subject">
        <label>국어:</label>
        <input
          type="number"
          value={korea}
          onChange={(e) => onScoreChange(id, "korea", e.target.value)}
        />
      </div>
      <div className="subject">
        <label>영어:</label>
        <input
          type="number"
          value={eng}
          onChange={(e) => onScoreChange(id, "eng", e.target.value)}
        />
      </div>
      <div className="subject">
        <label>수학:</label>
        <input
          type="number"
          value={math}
          onChange={(e) => onScoreChange(id, "math", e.target.value)}
        />
      </div>
      <div className="result">
        <p>총점: {total}</p>
        <p>평균: {average.toFixed(2)}</p>
        <p>등급: {grade}</p>
      </div>
    </div>
  );
}

export default BunComponent;
