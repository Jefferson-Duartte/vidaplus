package com.jefferson.vidaplus.dto;

public record UsuarioRequest(
        String nome,
        String email,
        String senha,
        String perfil
) {
}