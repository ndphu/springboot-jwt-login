package com.example.login.service;

import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public boolean isTokenValid(String token) {
        return "haha".equals(token);
    }
}
