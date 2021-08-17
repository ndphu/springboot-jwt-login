package com.example.login.controller;

import com.example.login.model.BlogPost;
import com.example.login.model.UserInfo;
import com.example.login.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class HelloController extends BaseController {

    private final BlogPostService blogPostService;

    public HelloController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping("/getBlogPosts")
    public List<BlogPost> getHello() {
        UserInfo currentUser = getCurrentUser();
        return blogPostService.getBlogPostByUserId(currentUser.getUserId());
    }
}
