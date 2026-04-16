package com.dunnas.ChamadoServicoCondominio.Application.UseCases;

import com.dunnas.ChamadoServicoCondominio.Domain.Core.Role;
import com.dunnas.ChamadoServicoCondominio.Domain.Core.UserEntity;
import com.dunnas.ChamadoServicoCondominio.Domain.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListAllWorkersUseCase {
    @Autowired
    private UserService userService;

    public List<UserEntity> execute() {
        return userService.getAllUsers(Role.WORKER);
    }
}
