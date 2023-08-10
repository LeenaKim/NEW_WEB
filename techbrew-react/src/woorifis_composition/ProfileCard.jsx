import React, {useState} from "react";
import Card from "./Card";

function ProfileCard(props){
    return (
        // specialization
        <Card   title="김우리"
                backgroundColor="#4ea04e">
            <p>안녕하세요, 김우리 입니다.</p>
            <p>지금, 합성에 대해서 학습하고 있습니다.</p>
        </Card>
    );
};

export default ProfileCard;