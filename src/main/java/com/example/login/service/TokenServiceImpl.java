package com.example.login.service;

import com.example.login.exception.InvalidJwtAthenticationException;
import com.example.login.model.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public UserInfo parseToken(String token) {
        // TODO : should parse JWT
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
                break;
            }
            default:
                throw new InvalidJwtAthenticationException("Fail to parse token to user info");
        }
        UserInfo info = new UserInfo();
        info.setUserId(fakeId);
        return info;
    }
}
