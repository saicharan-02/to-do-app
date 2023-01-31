import React, { useContext } from "react";
import { FaCheck } from "react-icons/fa";
import userContext from "../context/userData/userContext";

function Task(props) {
  const { tasks, setTasks } = useContext(userContext);

  function deleteTask() {
    fetch(`http://localhost:8081/task/deleteTask?id=${props.indTask.taskId}`, {
      method: "DELETE",
      headers: { "Content-Type": "application/json" },
    });
    const updatedTodoItems = tasks.filter(
      (data) => data.taskId !== props.indTask.taskId
    );
    setTasks([...updatedTodoItems]);
  }

  return (
    <div
      className={`flex flex-row ${
        props.index % 2 === 0 ? "" : "bg-slate-300"      
      } px-6 py-2 `}
    >
      <p className="w-[23rem] break-words">
        {`${props.index}. ${props.indTask.task}`}
      </p>

      <FaCheck
        onClick={() => {
          deleteTask();
        }}
        className="m-1 text-purple-800 cursor-pointer hover:scale-125 transition-all duration-300 ease-in"
      />
    </div>
  );
}

export default Task;
