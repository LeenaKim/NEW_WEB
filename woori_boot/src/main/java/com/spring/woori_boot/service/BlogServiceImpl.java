package com.spring.woori_boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.woori_boot.domain.CommentRequestDTO;
import com.spring.woori_boot.domain.CommentResponseVO;
import com.spring.woori_boot.domain.PostRequestDTO;
import com.spring.woori_boot.domain.PostResponseVO;
import com.spring.woori_boot.mapper.CommentMapper;
import com.spring.woori_boot.mapper.PostMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl {

    private final PostMapper postMapper;
    private final CommentMapper commentMapper;

    public List<PostResponseVO> blogsService() {
        System.out.println(">>>> ctrl blogs ");
        List<PostResponseVO> list = postMapper.list();
        return list;
    }

    public void blogSaveService(PostRequestDTO params){
        System.out.println(">>>> ctrl blogs save ");
        postMapper.save(params);
    }

    public PostResponseVO blogViewService(PostRequestDTO params){
        System.out.println(">>>> ctrl blogs view ");
        PostResponseVO response = postMapper.view(params);
        List<CommentResponseVO> comment = commentMapper.viewComment(params);
        response.setComments(comment);
        return response;
    }

    public void commentSaveService(CommentRequestDTO params){
        System.out.println(">>>> ctrl comment save ");
        commentMapper.save(params);
    }
}
