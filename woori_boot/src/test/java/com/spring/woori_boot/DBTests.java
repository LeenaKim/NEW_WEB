package com.spring.woori_boot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.spring.woori_boot.domain.CommentRequestDTO;
import com.spring.woori_boot.domain.CommentResponseVO;
import com.spring.woori_boot.domain.PostRequestDTO;
import com.spring.woori_boot.domain.PostResponseVO;
import com.spring.woori_boot.mapper.CommentMapper;
import com.spring.woori_boot.mapper.PostMapper;

@SpringBootTest
public class DBTests {

    @Autowired
    private ApplicationContext context;
    
    @Autowired
    private PostMapper postMapper;

    @Autowired
    private CommentMapper commentMapper;
    
    @Test
    public void testByApplicationContext() {
        try{
            System.out.println("====================");
            System.out.println(context.getBean("mariaFactory"));
            System.out.println("====================");
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void unitTestPostSave() {
        /////// Controller params
        PostRequestDTO request = new PostRequestDTO();
        request.setTitle("휴강안내");
        request.setContent("내일은 쉽니다....");
        ///////

        System.out.println("mapper >>>>>>>>>>>>>> " + postMapper);
        postMapper.save(request);
    }

    @Test
    public void unitTestPostList() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>> blog list");
        List<PostResponseVO> list = postMapper.list();
        for(PostResponseVO vo : list){
            System.out.println(vo.toString());
        }
    }
    // blog 1번 게시글에 댓글을 2개 달아본다면?
    @Test
    public void unitTestAddComment() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>> adding comments...");
        CommentRequestDTO request = new CommentRequestDTO();
        request.setBlog_id(1);
        request.setContent("계속 공부만 하고 싶어요!");
        
        commentMapper.save(request);
    
    }

    // 리액트에서 글보기 blog 1번 게시글을 클릭했을 때
    // blog content, comments 가져와야 함
    // params 값을 받아서 해당 블로그의 상세와 댓글을 리스트 형태로 담을 수 있어야 한다.
    @Test
    public void unitTestPostView() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>> post view");
        PostRequestDTO params = new PostRequestDTO();
        params.setId(1);
        PostResponseVO response = postMapper.view(params);
        System.out.println("=========== response : " + response);
        List<CommentResponseVO> comment = commentMapper.viewComment(params);
        response.setComments(comment);


        System.out.println("post content : " + response.getContent());
        System.out.println("post id : " + response.getId());
        System.out.println("post title : " + response.getTitle());
        System.out.println("post comments : " + response.getComments());
    
    }
}
