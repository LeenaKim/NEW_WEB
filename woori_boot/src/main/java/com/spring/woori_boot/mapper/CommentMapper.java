package com.spring.woori_boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.woori_boot.domain.CommentRequestDTO;
import com.spring.woori_boot.domain.CommentResponseVO;
import com.spring.woori_boot.domain.PostRequestDTO;

@Mapper
public interface CommentMapper {
    public void save(CommentRequestDTO params);
    public List<CommentResponseVO> viewComment(PostRequestDTO params);
}
