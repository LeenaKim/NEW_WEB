React Basic - 인프런 프로젝트로 배우는 리액트



# 02 폴더구조 살펴보기

- `package.json` : npm을 통해 설치한 패키지 리스트
  - `script` 에 npm을 사용할 때 썼던 함수들이 있음
- node_modules 폴더에 실제 패키지가 설치됨. 패키지들이 의존하고있는 다른 패키지까지 다 설치됨.
- Public 폴더 : 
  - `index.html` : 리액트 앱을 브라우저에서 열면 제일 먼저 가져오는 파일
  - root id div 안에 모든게 들어감
- src 폴더 :
  - `index.js` : App이란 컴포넌트를 가져와 그려줌



# 03 컴포넌트

- 컴포넌트 만드는법 2가지

  - Class 이용 (이전)
  - react hooks 가 생기며 함수를 이용해서 만듦 -> 코드 간결 & 권장

- App.js 내 App() function의 return값은 한 div tag로 묶여있어야 한다. 이때 유용하게 쓸 수 있는것이 `<React.Fragment>`. 이것으로 감싸주면 됨.

  - ```react
    import React from 'react';
    
    function App(){
      const number = 1;
    
      const double = (number) => {
        return number * 2;
      };
    
      double();
    
      return (
        <React.Fragment>
          <div>{double(number)}</div>
          <button>Submit</button>
        </React.Fragment>
      );
    }
    ```

  - `<React.Fragment>` 도 귀찮으니 그냥 <></> 로 감싸도 동일.

- react component는 함수 내에서 변수값이 바뀐다고 해서 다시 렌더링 되지 않음. 이를 위해선 react hooks의 use state를 사용해야 함. 일반 변수 사용시 렌더링이 되지 않기 때문에 화면에선 바뀌지 않음

- 렌더링은 App() 내 return 할때 일어나기 때문에 number * 2를 하는 함수 내에서 console.log 를 찍으면 숫자가 변하지 않음. 이럴땐 새로운 변수를 세워서 그것을 set하고 콘솔 찍어야함

  - ```react
    function App(){
      const [number, setNumber] = useState(1); // [변수, 함수]
      const double = () => {
        const doubledNum = number * 2;
        setNumber(doubledNum);
        console.log(doubledNum);
      };
      return (
        <>
          <div>{number}</div>
          <button onClick={double}>Submit</button>
        </>
      );
    }
    ```

  - 