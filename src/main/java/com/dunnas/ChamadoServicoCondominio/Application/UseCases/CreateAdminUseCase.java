package com.dunnas.ChamadoServicoCondominio.Application.UseCases;

import com.dunnas.ChamadoServicoCondominio.Domain.Core.Role;
import com.dunnas.ChamadoServicoCondominio.Domain.Core.UserEntity;
import com.dunnas.ChamadoServicoCondominio.Domain.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateAdminUseCase {
    @Autowired
    private UserService userService;

    public UserEntity execute(UserEntity user) {
        if (user.getLogin() == null || user.getPassword() == null || user.getName() == null) {
            throw new IllegalArgumentException("Login, password and name are required");
        }
        if (userService.getUserByLogin(user.getLogin()).isPresent()) {
            throw new IllegalArgumentException("Login already exists");
        }
        user.setRole(Role.ADMIN);
        return userService.createUser(user);
    }

}
