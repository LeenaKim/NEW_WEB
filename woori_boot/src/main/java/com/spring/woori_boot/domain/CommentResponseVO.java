package com.spring.woori_boot.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentResponseVO {
    private int id;
    private String content;
    private int blog_id;
}
