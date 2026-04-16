package com.dunnas.ChamadoServicoCondominio.Application.UseCases;

import com.dunnas.ChamadoServicoCondominio.Domain.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteWorkerUseCase {
    @Autowired
    private UserService userService;

    public void execute(String id) {
        try{
            userService.deleteUser(UUID.fromString(id));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid UUID format: " + id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting user with id " + id + ": " + e.getMessage());
        }
    }
}
