package com.example.login.controller;

import com.example.login.model.LoginRequest;
import com.example.login.model.LoginResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponse login(@RequestBody LoginRequest req) {
        if ("phu".equals(req.getUsername())
            && "123".equals(req.getPassword())) {
            LoginResponse resp = new LoginResponse();
            resp.setToken("some_token");
            return resp;
        }
        throw new RuntimeException("Login Failed!");
    }

}
