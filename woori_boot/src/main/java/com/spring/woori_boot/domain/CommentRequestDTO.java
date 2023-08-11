package com.spring.woori_boot.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDTO {
    private String content;
    private int blog_id;
}
