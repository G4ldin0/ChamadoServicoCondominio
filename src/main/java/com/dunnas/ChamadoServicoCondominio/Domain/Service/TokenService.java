package com.dunnas.ChamadoServicoCondominio.Domain.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dunnas.ChamadoServicoCondominio.Domain.Core.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.jwt.secret}")
    private String secret;
    @Value("${api.security.jwt.expiration-hours}")
    private int expirationHours = 1;

    public String gerarToken(UserEntity userEntity) {
        Algorithm algoritmo = Algorithm.HMAC256(secret);
        String token = JWT.create()
                .withIssuer("auth-api")
                .withSubject(userEntity.getId().toString())
                .withClaim("login", userEntity.getLogin())
                .withClaim("role", userEntity.getRole().toString())
                .withExpiresAt(getExpirationDate())
                .sign(algoritmo);
        return token;
    }

    public String validateToken(String token) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            var decodedToken = JWT.require(algoritmo)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token);
            return decodedToken.getSubject();
        } catch (Exception e) {
            return "";
        }
    }

    private Instant getExpirationDate(){
        return LocalDateTime.now().plusHours(expirationHours).toInstant(ZoneOffset.of("-03:00"));
    }
}
