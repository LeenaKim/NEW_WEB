23.08.09 리액트 스프링boot 교육 in 테크브루



[toc]

<u>리액트</u>

# 배경

- SPA(Single Page Application - html 하나로만 어플리케이션 제작) : 비동기를 기본으로 함.

- angular, react, vue

- react는 본인을 UI 인터페이스를 만들 수 있는 라이브러리로 소개, angular & vue는 프레임워크

- react 에서 필요한 것들

  1. script
  2. html
     - 기존의 html 을 리액트의 요소에 렌더링할 수 있도록 virtual dom -> real dom 

- 프레임워크 vs 라이브러리

  - 프레임워크 사용 이유 : inversion of control(IOC - 제어의 역행) - **객체들의 생명주기**가 프레임워크의 컨테이너에 의해 제어됨
  - 라이브러리 : 객체들의 생명주기를 개발자가 제어할 수 있다. angular, vue는 프레임웤이기 때문에 개발자가 제어 불가

- 리액트의 장점

  - 빠른 업데이트 & 렌더링 속도 
  - virtual DOM : 
    - 실제로 눈에 보이지 않음
    - 개발자가 virtual DOM을 건드린다는 느낌을 받을 수 없음. 
  - DOM : document 상의 태그들을 object의 model로 이해하자! 브라우저 돔엔 리액트 virtual DOM이 있다고 이해. 
  - 기존 브라우저 : document 상에서 특정 데이터가 변경될 시 상태변경 발생 -> 특정 노드가 아니라 전체 브라우저 도큐멘트가 렌더링
  - virtual DOM : 상태변경 발생 -> 변경된 state만 찾아서 virtual DOM에서 빠르게 업데이트 시킨다. => 실제 사용자 눈에 보이는건 virtual DOM에서 발생된 리렌더링이 먼저 보여지고, 그 후 실제 DOM에 적용된다. 
    - 상태관리
      - 기존 http 방식 : **state-less, connection-less**. 상태를 저장해놓지 않아 로그인을 해야 들어갈 수 있는 페이지에 들어가면 재로그인 해야함. 이를 개선하기 위해 쿠키같은 것들이 나온 것. 
      - SPA : state를 관리함. react는 이를 위해 hook이나 redux 등을 사용. 
  - Component-Based : 컴포넌트는 객체지향 관점에서 클래스와 비슷하다. (틀) html을 react의 virtual DOM에서 렌더링하기 위해선 **엘리먼트**를 만들어야 함. 엘리먼트를 만들기 위해선 컴포넌트가 필요. 컴포넌트는 스크립트의 function을 통해 생성. 
    - 컴포넌트를 만드는 스크립트 function은 element를 리턴함. element를 까보면사실 스크립트의 객체(key-value로 이뤄져있는 객체 타입)이다.

  

# 개발환경 세팅

- Node.js, NPM

- `npx` : x 는 execute를 의미. 의존관계에 있는 라이브러리까지 다 실행하여 개발환경 만들기.

- npx create-react-app <techbrew-react>  
- JSX : Javascript + XML / HTML 
  - semantic tag(약속되어있는 태그) - 우리가 만드는 컴포넌트를 태그처럼 쓸 수 있게 하는 것이 jsx
- `index.html`  이 파일트리에는 없지만 빌드할때 만들어짐. 



# React basic

- 엘레먼트를 react가 파싱해서 엘레먼트 내의 children 태그들을 조작할 수 있게됨
- 중괄호{} : 리액트에서 스크립트 변수를 사용할 때 

- `export` : 다른쪽에서 `import` 해서 쓸 수 있다.
- component를 만들 땐 반드시 대문자
- `export default Employee` : default를 쓰면서 import 할 시 그냥 import Employee 로 가능하게 함. 그 외일 경우 import {Employee} 



# Element

## Element 란?

- Elements are the smallest building blocks of React apps.
- 컴포넌트를 만들 때 아주 작은 소단위로 만들어 조합해야 한다.
- Elements는 화면(Virtual DOM)에서 보이는 것들을 기술
- 엘레먼트의 텍스트 내용 자체도 props의 children이다.
- React elements are immutable : 기존의 element를 수정할 수 없고, 새 element를 만들어서 대체를 해야한다(render)

## `Clock.jsx` 실습

- 개발자도구 내 elements 에서 root div가 계속 깜박인다 => 2초마다 렌더링이 새로되고 있다.



# Components and props

- 레고 블록 조립하듯 컴포넌트들을 모아서 개발
- 리액트 컴포넌트 : 입력 `props`, 출력 `react component` 

- props
  - component 의 속성
  - 컴포넌트에 전달할 다양한 정보를 담고 있는 자바스크립트 객체 - 중괄호 필요
  - read-only : 값을 변경할 수 없다.
  - 새로운 값을 컴포넌트에 전달하여 새로 element를 생성
- component를 가지고 element를 만들어낼 때 다양한 props를 가지고 만든다.
- JavaScript 함수의 속성
  - 입력값을 변경하지 않으면, 같은 입력값에 대해서는 항상 같은 출력값을 리턴 ("pure") 하게 만들어야 함
- jsx 파일엔 css, html, js 다 사용 가능



# State and Lifecycle

## State

- 리액트 component의 상태, 리액트 component의 변경 가능한 데이터
- 개발자가 정의한다.
- 렌더링이나 데이터 흐름에 사용되는 값만 state에 포함시켜야 함 !
- state는 JavaScript 객체이다.
- state는 직접 수정할 수 없다 (하면 안된다)

## Lifecycle

- 출생, 인생, 사망

## Hooks

- 함수형 컴포넌트에서 상태주기 관리하기 위한 개념
- 클래스 컴포넌트에선 state를 직접 가져다 `setState` 등으로 변경시킬 수 있지만, 함수형 컴포넌트에선 직접 건드릴 수 없기 때문에 hook으로 사용
- hook은 컴포넌트가 렌더링될 때마다 매번 같은 순서로 호출되어야 한다.
-  Custom Hook도 만들 수 있다. 마치 Exception 클래스를 상속받아 커스터마이징 하는 것 처럼.

- `useState` : state를 사용하기 위한 hook 
- `useEffect` : 사이드이펙트를 위한 hook
  - 다른 컴포넌트에 영향을 미칠 수 있으며, 렌더링 중에는 작업이 완료될 수 없기 때문에 렌더링하는 중간에 side effect를 주면 안된다. 
  - 렌더가 일어난 직후에 effect를 넣고싶을 때 사용
  - 컴포넌트가 마운드 퇬을 때 (처음 나타났을 때), 언마운트 됐을 때 (사라질 때), 그리고 업데이트 될 때 (특정 props가 바뀔 때) 특정 작업을 처리하는 용도
  - 매개변수중 의존성 배열을 넣지 않으면 마운트시에만 함수가 호출됨
  - 언마운트될때 호출되는 `clean up` 함수 정의 가능 

- { useState, useEffect } : default로 export를 하지 않기 때문에 중괄호 써줌
- Custom Hook : 이름이 use로 시작하고 내부에서 다른 hook을 호출하는 자바스크립트 함수.
- hook들간 데이터 교환법



# Handling Events

## Event

- 특정 사건을 의미

- 리액트에서는 event 발생시 함수를 호출하지 않고, 함수를 넘겨준다.

  ```react
  <button onClick={eventHandler}></button>
  ```

  

## Event Listener

- event와 event handler을 연결

## Conditional Rendering

- React에서는 원하는 동작을 캡슐화하는 컴포넌트를 만들 수 있습니다. 이렇게 하면 애플리케이션의 상태에 따라서 컴포넌트 중 몇 개만을 렌더링할 수 있습니다.

  React에서 조건부 렌더링은 JavaScript에서의 조건 처리와 같이 동작합니다. [`if`](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Statements/if...else) 나 [`조건부 연산자`](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Conditional_Operator) 와 같은 JavaScript 연산자를 현재 상태를 나타내는 엘리먼트를 만드는 데에 사용하세요. 그러면 React는 현재 상태에 맞게 UI를 업데이트할 것입니다.

```react
function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}
```



## element variable

- 컴포넌트로 element를 만들어서 변수에 저장해서 쓰는 방법



## Inline Condition

- 조건부 렌더링을 할 때 자주 쓰게되는 개발 문법
- 조건문을 코드 안에 집어넣는 것
- if문의 경우 && 연산자 사용
- true && expression -> expression
- false && expression -> false



# Lists and Keys

- List : 스크립트 배열
- Key의 값은 같은 List에 있는 Elements 사이에서만 고유한 값이면 된다. 예를들어 `<li>` 태그를 여러개 그리면 내부적으로 인덱스가 있어서 키가 있다고 생각하지만, 리액트에서는 키값을 명시적으로 주어야 함.
- map() 함수 안에 있는 Elements는 꼭 key가 필요하다 !

```react
react-jsx-dev-runtime.development.js:87 Warning: Each child in a list should have a unique "key" prop.

Check the render method of `AttendanceBook`. See https://reactjs.org/link/warning-keys for more information.
    at li
    at AttendanceBook
```

```react
function AttendanceBook(props) {
    return (
        <ul>
            {students.map((student, index) => {
                return <li key={index}>{student.name}</li>
            })}
        </ul>
    );
};
```



# Forms

## Compositioin

- 여러 개의 컴포넌트를 합쳐서 새로운 컴포넌트를 만드는 것

1. Containment 

- 하위 컴포넌트를 포함하는 형태의 합성 방법
- Sidebar나 dialog 같은 box 형태의 컴포넌트는 자신의 하위 컴포넌트를 미리 알 수 없다. 
- children이라는 prop을 사용해서 조합!

2. specialization

## Context

- 세션과 같은 별도의 메모리 공간
- 데이터를 공유해야 할 때 사용 ex) 로그인 여부, 로그인 정보, UI 테마, 현재 언어 등
- 기존 props를 쓰던 방식보다 효율적이고 계속해서 props를 넘겨받지 않아도 됨
- 단점 : 부모에서 렌더링하면 자식까지 영향을 받음. 



# mini-blog 프로젝트

```react
npm install --save react-router-dom styled-components
```

- 패키지를 깔면 package.json 에 router과 styled-component가 설치된 것 확인 가능

- 간단하게 생각 하자면 사용자가 요청한 URL에 따라 해당 URL에 맞는 페이지를 보여주는 것이라고 생각할 수 있다.
- 라우터는 최상위인 `App.js` 에 들어가야 함

- router가 있어야 화면에 대한 transition이 발생 가능 
- `BrowserRouter` > `Routes` > `Route` 순서대로 감쌈
- 실제 이동할 화면은 `Route` 에 걸음. path가 라우트에 걸려있어야 그 path를 이벤트에 등록할 수 있음

```REACT
function App(props) {
    return (
        <BrowserRouter>
            <Routes>
                <Route index element={<MainPage/>}></Route>
            </Routes>
        </BrowserRouter>
    );
}
```

- `index` : = `path="index"` path의 이름을 index로 지정
- `path` : request path

- `path="post/:postId"` : path와 함께 값을 넘겨주고 싶을 때 사용

```react
const {comments} = props;
```

- 위처럼 props나 리액트 모듈에서 가져온 변수를 자바스크립트에 쓸때는 자바스크립트 변수로의 변환이 필요하기 때문에 중괄호가 필요하다.



