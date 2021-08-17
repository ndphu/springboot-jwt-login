package com.example.login.exception;

import org.springframework.security.core.AuthenticationException;

public class InvalidJwtAthenticationException extends AuthenticationException {
    public InvalidJwtAthenticationException(String msg) {
        super(msg);
    }
}
