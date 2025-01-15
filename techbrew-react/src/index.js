import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

/* const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
); */

/* import Company from './woorifis_jsx/Company';
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Company />
  </React.StrictMode>
); */

// element 실습
/* import Clock from './woorifis_elements/Clock';

// 2초에 한번씩 렌더링이 되며 element를 새로 생성
setInterval( () => { 
  const root = ReactDOM.createRoot(document.getElementById('root'));
    root.render(
      <React.StrictMode>
        <Clock
         />
      </React.StrictMode>
    ); 
}, 2000); */

// compoment 실습
/* import CommentList from './woorifis_component/CommentList';
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <CommentList />
  </React.StrictMode>
); */

// hook 실습
/* import Accommodate from './woorifis_hook/Accommodate';
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Accommodate />
  </React.StrictMode>
); */

// event 실습
/* import ConfirmButton from './woorifis_event/ConfirmButton';
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <ConfirmButton />
  </React.StrictMode>
); */

// rendering 실습
/* import LandingPage from './woorifis_rendering/LandingPage';
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <LandingPage />
  </React.StrictMode>
); */

// list 실습
import AttendanceBook from './woorifis_list/AttendanceBook';
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <AttendanceBook />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
