package com.spring.woori_boot.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.woori_boot.domain.CommentRequestDTO;
import com.spring.woori_boot.domain.CommentResponseVO;
import com.spring.woori_boot.domain.PostRequestDTO;
import com.spring.woori_boot.domain.PostResponseVO;
import com.spring.woori_boot.service.BlogServiceImpl;
/*
Annotation
Create - @Component, @Controller, @Service, @Repository, @Bean, @Mapper, @Configuration
Dependency Injection - @Autowired, @Qualifier, @Resource, @Inject
request path - @GetMapping, @PostMapping, @RequestMapping
params - @RequestParam, @RequestPath etc...
json - @RestController, @ResponseBody
 */
@RestController
public class BlogCtrl {
    // Dependency Injection
    @Autowired
    private BlogServiceImpl service;

    // blogs
    @RequestMapping(value="/index")
    @CrossOrigin
    public List<PostResponseVO> blogs() {
        System.out.println(">>>> ctrl blogs ");
        return service.blogsService();
    }

    @RequestMapping(value="/save")
    @CrossOrigin
    public String blogSave(PostRequestDTO params){
        System.out.println(">>>> ctrl blogs save ");
        service.blogSaveService(params);
        return "OK";
    }

    @RequestMapping(value="/view")
    @CrossOrigin
    public PostResponseVO blogView(PostRequestDTO params){
        System.out.println(">>>> ctrl blogs view ");
        return service.blogViewService(params);
    }

    @RequestMapping(value="/commentSave")
    @CrossOrigin
    public String commentSave(CommentRequestDTO params){
        System.out.println(">>>> ctrl comment save ");
        service.commentSaveService(params);
        return "OK";
    }

    /// 
    @GetMapping(value="/json") // 브라우저에서 직접 치고 들어오는건 GetMapping
    public PostResponseVO showMsg() {
        System.out.println(">>>>>> ctrl showMsg");
        PostResponseVO response = new PostResponseVO();
        response.setId(1);
        response.setTitle("test");
        response.setContent("하이루...방가방가");
        return response;
    }
}
