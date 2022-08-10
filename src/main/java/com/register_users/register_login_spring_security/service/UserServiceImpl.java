package com.register_users.register_login_spring_security.service;

import com.register_users.register_login_spring_security.dto.UserRegisterDTO;
import com.register_users.register_login_spring_security.model.Rol;
import com.register_users.register_login_spring_security.model.Users;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.register_users.register_login_spring_security.repository.UserRepository;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private UserRepository userRepository;


    @Override
    public Users save(UserRegisterDTO registerDTO) {
        Users user = new Users(registerDTO.getName(),
                registerDTO.getLastname(),
                registerDTO.getEmail(),
                passwordEncoder.encode(registerDTO.getPassword()),
                Arrays.asList(new Rol("ROLE_USER"))
        );
        return userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User or password invalids");
        }
        return new User(user.getEmail(), user.getPassword(), mapAuthoritiesToRoles(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapAuthoritiesToRoles(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }
}


