package com.jefferson.vidaplus.controller;

import com.jefferson.vidaplus.dto.request.LoginRequest;
import com.jefferson.vidaplus.dto.response.TokenResponse;
import com.jefferson.vidaplus.dto.request.UsuarioRequest;
import com.jefferson.vidaplus.dto.response.UsuarioResponse;
import com.jefferson.vidaplus.security.TokenService;
import com.jefferson.vidaplus.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final TokenService tokenService;
    private final UsuarioService usuarioService;

    public AuthController(AuthenticationManager authManager, TokenService tokenService, UsuarioService usuarioService) {
        this.authManager = authManager;
        this.tokenService = tokenService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.senha())
        );

        UserDetails user = (UserDetails) auth.getPrincipal();
        String jwt = tokenService.gerarToken(user);
        return ResponseEntity.ok(new TokenResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponse> cadastrar(@RequestBody UsuarioRequest request) {
        UsuarioResponse response = usuarioService.cadastrarUsuario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
