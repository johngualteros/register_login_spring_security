package com.register_users.register_login_spring_security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.register_users.register_login_spring_security.dto.UserRegisterDTO;
import com.register_users.register_login_spring_security.model.Users;
import java.util.List;
public interface UserService extends UserDetailsService{
    
    public Users save(UserRegisterDTO registerDTO);
    public List<Users> findAll(); 
}
