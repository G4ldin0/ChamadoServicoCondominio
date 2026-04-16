package com.dunnas.ChamadoServicoCondominio.Application.UseCases;

import com.dunnas.ChamadoServicoCondominio.Domain.Core.UserEntity;
import com.dunnas.ChamadoServicoCondominio.Domain.Service.TokenService;
import com.dunnas.ChamadoServicoCondominio.Domain.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class AuthenticateUserUseCase {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public String execute(String login, String password) {
        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login, password);
        var auth = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if (!auth.isAuthenticated()) {
            return "";
        }
        UserEntity user = (UserEntity) auth.getPrincipal();
        return tokenService.gerarToken(user);
    }
}
