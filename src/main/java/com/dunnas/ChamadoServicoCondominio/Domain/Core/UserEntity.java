package com.dunnas.ChamadoServicoCondominio.Domain.Core;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Users")
public class UserEntity implements UserDetails {

    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_login")
    private String login;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public UserEntity(){

    }

    public UserEntity(String name, String login, String password, Role role) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role == Role.ADMIN)
            return List.of(() -> "ROLE_ADMIN", () -> "ROLE_USER", () -> "ROLE_WORKER");
        if (role == Role.WORKER)
            return List.of(() -> "ROLE_WORKER");
        return List.of(() -> "ROLE_USER");
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
