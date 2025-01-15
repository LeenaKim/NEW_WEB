import React from "react";

const students = [
    { idx : 1, name : "wooribank" },
    { idx : 2 , name : "woorifis" },
    { idx : 3 , name : "wooricard" }
];

function AttendanceBook(props) {
    return (
        <ul>
            {students.map((student, index) => {
                return <li key={student.idx}>{student.name}</li>
            })}
        </ul>
    );
};

export default AttendanceBook;