package com.jefferson.vidaplus.dto.request;

public record UsuarioRequest(
        String nome,
        String email,
        String senha,
        String perfil
) {
}