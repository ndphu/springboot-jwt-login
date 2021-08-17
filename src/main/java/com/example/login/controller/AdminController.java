package com.example.login.controller;

import com.example.login.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @GetMapping("/users")
    public List<User> getUsers() {
        User u1 = new User();
        u1.setName("oanh123");
        User u2 = new User();
        u2.setName("phu456");
        return Arrays.asList(u1, u2);
    }
}
