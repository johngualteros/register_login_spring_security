package com.register_users.register_login_spring_security.model;


import javax.persistence.*;
import java.util.Collection;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "users" ,uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Users{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",length = 55)
    @NotEmpty(message="The name can´t be null")
    @Size(min = 2, max = 55, message="name must be between 2 and 55 characters")
    private String name;
    @Column(name = "lastname",length = 55)
    @NotEmpty(message="The last name can´t be null")
    @Size(min = 2, max = 55, message="last name must be between 2 and 55 characters")
    private String lastname;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
         name = "users_roles",
         joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
         inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )
    private Collection<Rol> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }

    public Users(Long id, String name, String lastname, String email, String password, Collection<Rol> roles) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Users(String name, String lastname, String email, String password, Collection<Rol> roles) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Users(){
        super();
    }

    public Users(String email2, String password2, Collection<? extends GrantedAuthority> mapAuthoritiesToRoles) {
    }
}
