package com.register_users.register_login_spring_security.repository;

import com.register_users.register_login_spring_security.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    public Users findByEmail(String email);
}
