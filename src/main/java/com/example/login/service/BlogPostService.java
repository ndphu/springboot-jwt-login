package com.example.login.service;

import com.example.login.model.BlogPost;

import java.util.List;

public interface BlogPostService {
    List<BlogPost> getBlogPostByUserId(String userId);
}
