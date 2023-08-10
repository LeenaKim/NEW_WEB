import React, { useState, useEffect } from "react";
import useCounter from "./useCounter";

const MAX_CAPACITY = 10;

function Accommodate(props) {
    const [isFull, setIsFull] = useState(false);
    const [count, increaseCount, decreaseCount, nothing] = useCounter(0); // 사용자 정의 훅 - 상황에 따라 set함수 정의 안할수도 있음
    // count의 값은 사용자정의 훅 내에서 변경이 이루어짐(setCount)

    useEffect(() => {
        console.log("======================");
        console.log("useEffect() is called.");
        console.log(`isFull: ${isFull}`); // 컴포넌트가 렌더링 될때마다 호출
    });

    useEffect(() => {
        setIsFull(count >= MAX_CAPACITY); // 상태값 변경
        console.log(`Current count value: ${count}`);
    }, [count]); // 의존성배열이 있기 때문에 첫 번째 렌더링 & count가 변경될 때마다 호출됨.

    return (
        <div style={{ padding: 16 }}>
            <p>{`총 ${count}명 수용했습니다.`}</p>

            <button onClick={increaseCount} disabled={isFull}>
                입장
            </button>
            <button onClick={decreaseCount}>퇴장</button>
            <button onClick={nothing}>아무것도 안함</button>

            {/* isFull이 false면 뒤에 <p>태그를 수행하지 않음 => "조건부 렌더링" */} 
            {isFull && <p style={{ color: "red" }}>정원이 가득찼습니다.</p>}
        </div>
    );
}
export default Accommodate;