package com.example.login.service;

import com.example.login.model.BlogPost;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class BlogPostServiceImpl implements BlogPostService {
    @Override
    public List<BlogPost> getBlogPostByUserId(String userId) {
        switch (userId) {
            case "oanh123": {
                BlogPost p1 = new BlogPost();
                p1.setTitle("AAAA");
                p1.setContent("Content of AAAA");
                BlogPost p2 = new BlogPost();
                p2.setTitle("BBBB");
                p2.setContent("Content of BBBB");
                return Arrays.asList(p1, p2);
            }
            case "phu456": {
                BlogPost p1 = new BlogPost();
                p1.setTitle("CCC");
                p1.setContent("Content of CCC");
                return Collections.singletonList(p1);
            }
            default:
                return Collections.emptyList();
        }
    }
}
