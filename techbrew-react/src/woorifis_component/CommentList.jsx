import React , { useState }   from "react";
import Comment from "./Comment";

const comments = [
    { name : "김우리", comment : "우리WON뱅킹을 써보아요~!"}
    , { name : "박하나", comment : "하나원큐를 써보아요"}
    , { name : "최농협", comment : "농협쓰세요 여러분"}
];

function CommentList(props){
    return (
        <div>
            {comments.map( (comment) => {
                return (
                    <Comment name={comment.name} comment={comment.comment}/>
                );
            })}
        </div>
    );
}

export default CommentList;