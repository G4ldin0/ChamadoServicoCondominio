package com.dunnas.ChamadoServicoCondominio.Infra.Controllers.Configurations;

import com.dunnas.ChamadoServicoCondominio.Domain.Core.UserEntity;
import com.dunnas.ChamadoServicoCondominio.Domain.Repository.UserRepository;
import com.dunnas.ChamadoServicoCondominio.Domain.Service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String token = extractToken(request);
        if (token != null) {
            String user_id = tokenService.validateToken(token);
            UserEntity userEntity = userRepository.findById(UUID.fromString(user_id)).orElse(null);
            if (userEntity != null) {
                var auth = new UsernamePasswordAuthenticationToken(userEntity,  null, userEntity.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request, response);
    }



    private String extractToken(HttpServletRequest request) {
        var cookies = request.getCookies();
        String tokenFromCookie = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("token")).findFirst().map(cookie -> cookie.getValue()).orElse(null);
        if (tokenFromCookie != null)
            return tokenFromCookie;
        return null;
    }
}
