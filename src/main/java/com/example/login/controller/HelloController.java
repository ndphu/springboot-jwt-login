package com.example.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class HelloController {

    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }
}