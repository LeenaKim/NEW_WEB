package com.spring.woori_boot.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostResponseVO {
    private int id;
    private String title;
    private String content;
    ///////////// comments
    private List<CommentResponseVO> comments;
}
