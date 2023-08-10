import React from "react";

function Employee(props) {
    return (
        <div>
            <h1>{`당신의 이름은 ${props.name} 입니다.`}</h1>
            <h1>{`오늘의 점심은 ${props.menu} 입니다.`}</h1>
        </div>
    );
}

export default Employee;