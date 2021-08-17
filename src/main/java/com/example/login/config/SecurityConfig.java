package com.example.login.config;

import com.example.login.filter.AdminRoleFilter;
import com.example.login.filter.JwtAuthenticationFilter;
import com.example.login.security.JwtAuthenticationProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    public SecurityConfig(JwtAuthenticationProvider jwtAuthenticationProvider) {
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login").antMatchers("/register");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter("/**", this.authenticationManagerBean());
        AdminRoleFilter adminRoleFilter = new AdminRoleFilter("/admin/**", this.authenticationManagerBean());
        http
            .csrf().disable()
            .authorizeRequests()
            .and()
            .addFilterBefore(filter, BasicAuthenticationFilter.class)
            .authenticationProvider(jwtAuthenticationProvider)
            .addFilterAfter(adminRoleFilter, JwtAuthenticationFilter.class)
            .authorizeRequests()
            .anyRequest().authenticated()
            .and().httpBasic();

    }
}
