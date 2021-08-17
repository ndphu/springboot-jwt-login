package com.example.login.service;

import com.example.login.exception.InvalidJwtAuthenticationException;
import com.example.login.model.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public UserInfo parseToken(String token) {
        // TODO : should parse JWT
        UserInfo info = new UserInfo();
        String fakeId = "";
        switch (token) {
            case "haha": {
                fakeId = "oanh123";
                break;
            }
            case "hihi": {
                fakeId = "phu456";
                break;
            }
            case "hehe": {
                fakeId = "phuoanh123456";
                info.setRoles(new String[]{"admin"});
                break;
            }
            default:
                throw new InvalidJwtAuthenticationException("Fail to parse token to user info");
        }
        info.setUserId(fakeId);
        return info;
    }
}
