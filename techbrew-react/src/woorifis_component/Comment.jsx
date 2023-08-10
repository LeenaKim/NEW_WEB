import React    from "react";

const styles = {
    wrapper: {
        margin: 8,
        padding: 8,
        display: "flex",
        flexDirection: "row",
        border: "1px solid grey",
        borderRadius: 16,
    },
    imageContainer: {},
    image: {
        width: 50,
        height: 50,
        borderRadius: 25,
    },
    contentContainer: {
        marginLeft: 8,
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
    },
    nameText: {
        color: "black",
        fontSize: 16,
        fontWeight: "bold",
    },
    commentText: {
        color: "black",
        fontSize: 16,
    },
};

// 1. 댓글컴포넌트 만들기
/* function Comment(props){
    return (
        <div>
            <h1>섭섭이와 함께 즐겁지 아니한 리액트 첫 컴포넌트 실습</h1>
            <p>{props.title}</p>
            <p>{props.content}</p>
        </div>
    );
} */

// 2. Comment 컴포넌트에 스타일 입히기 
function Comment(props) {
    return (
        <div style={styles.wrapper}>
            <div style={styles.imageContainer}>
                <img
                    src="https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png"
                    style={styles.image}
                />
            </div>

            <div style={styles.contentContainer}>
                <span style={styles.nameText}>{props.name}</span>
                <span style={styles.commentText}>{props.comment}</span>
            </div>
        </div>
    );
}

export default Comment;