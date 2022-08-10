package com.register_users.register_login_spring_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class CustomConfig {
    @Bean
    public BCryptPasswordEncoder metodoCrittografia() {
        return new BCryptPasswordEncoder();
    }
}
