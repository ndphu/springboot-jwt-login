package com.example.login.filter;

import com.example.login.exception.InvalidJwtAthenticationException;
import com.example.login.security.JwtAuthentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationFilter(String matcher, AuthenticationManager authenticationManager) {
        super(matcher, authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String authorization = request.getHeader("Authorization");
        if (StringUtils.hasText(authorization)) {
            String token = authorization.substring("Bearer ".length());
            Authentication jwtAuth = new JwtAuthentication(token);
            return getAuthenticationManager().authenticate(jwtAuth);
        } else {
            throw new InvalidJwtAthenticationException("Missing authorization header");
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        if (authResult.isAuthenticated()) {
            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(authResult);
            chain.doFilter(request, response);
        } else {
            throw new InvalidJwtAthenticationException("Fail to authenticate request");
        }
    }
}
