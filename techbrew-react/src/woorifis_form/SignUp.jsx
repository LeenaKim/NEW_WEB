import React, { useState } from "react";

function SignUp(props){
    const [name, setName] = useState("");
    const [gender, setGender] = useState("female");

    const btnHandler = (event) => {
        alert(`이름 ${name} 성별 ${gender}`);
        event.preventDefault();
    }

    const nameHandler = (event) => {
        setName(event.target.value);
        event.preventDefault();
    }

    const genderHandler = (event) => {
        setGender(event.target.value);
        event.preventDefault();
    }
    return (
        <form onSubmit = {btnHandler}>
            <label>
                NAME : 
                <input type="text" value={name} onChange={nameHandler}/>
            </label>
            <br />
            <label>
                성별 :
                <select value={gender} onChange={genderHandler}>
                    <option value="male">male</option>
                    <option value="female">female</option>
                </select>
            </label>
            <button type="submit">SIGN</button>
        </form>
    );
}

export default SignUp;