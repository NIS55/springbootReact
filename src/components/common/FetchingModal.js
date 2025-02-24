import React from "react";

export const FetchingModel = () => {
  return (
    <div className="fixed top-0 left-0 z-[1055] flex h-full place-items-center bg-black bg-opacity-20">
      <div className="bg-white rounded-3xl opacity-100 min-w-min h-1/4 min-w-min[600px] flex justify-center items-center">
        <div className="text-4xl font-extralight text-orange-400 m-20">
          Loading...
        </div>
      </div>
    </div>
  );
};

export default FetchingModel;
