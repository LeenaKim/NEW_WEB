package com.spring.woori_boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.woori_boot.domain.PostRequestDTO;
import com.spring.woori_boot.domain.PostResponseVO;

@Mapper
public interface PostMapper {
    // blog
    public void save(PostRequestDTO params);
    public List<PostResponseVO> list();
    // blog include xomments
    public PostResponseVO view(PostRequestDTO params);
}
