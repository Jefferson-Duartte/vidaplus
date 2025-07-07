package com.jefferson.vidaplus.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jefferson.vidaplus.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(UserDetails usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withSubject(usuario.getUsername())
                    .withClaim("authorities", usuario.getAuthorities().stream()
                            .map(GrantedAuthority::getAuthority)
                            .toList())
                    .withIssuer("vidaplus-api")
                    .withIssuedAt(new Date())
                    .withExpiresAt(gerarDataDeExpiracao())
                    .sign(algorithm);

            return token;

        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao autenticar o usuário");
        }

    }

    public String extrairUsername(String token) {
        return validarToken(token).getSubject();
    }

    public boolean eTokenValido(String token, UserDetails user) {
        String username = extrairUsername(token);
        return username.equals(user.getUsername()) && !eExpirado(token);
    }

    private boolean eExpirado(String token) {
        return validarToken(token).getExpiresAt().before(new Date());
    }

    private DecodedJWT validarToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.require(algorithm)
                .withIssuer("vidaplus-api")
                .build()
                .verify(token);
    }

    private Instant gerarDataDeExpiracao() {
        return Instant.now().plus(15, ChronoUnit.MINUTES);
    }

}
