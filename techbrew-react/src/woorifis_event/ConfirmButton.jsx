import React, { useState, useEffect } from "react";

function ConfirmButton(props){
    const [isConfirmed, setIsConfirmed] = useState(false);

    const eventHandler = (event) => {
        setIsConfirmed((prevIsConfirmed) => !prevIsConfirmed);
    }
    
    return (
        <button onClick={(event) => eventHandler} disabled={isConfirmed}>
            { isConfirmed ? "확인됨" : "확인하기" }
        </button>
    );
}
export default ConfirmButton;