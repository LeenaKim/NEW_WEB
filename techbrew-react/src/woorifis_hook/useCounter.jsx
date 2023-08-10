// 사용자정의 hook
import React, { useCallback, useState } from "react";

function useCounter(initialValue) {
    const [count, setCount] = useState(initialValue);

    // 함수를 리턴
    const increaseCount = () => setCount((count) => count + 1);
    const decreaseCount = () => setCount((count) => Math.max(count - 1, 0));
    const nothing = () => setCount((count) => count);

    return [count, increaseCount, decreaseCount, nothing];
}
export default useCounter;