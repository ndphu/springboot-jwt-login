package com.example.login.service;

import com.example.login.model.UserInfo;

public interface TokenService {
    UserInfo parseToken(String token);
}
