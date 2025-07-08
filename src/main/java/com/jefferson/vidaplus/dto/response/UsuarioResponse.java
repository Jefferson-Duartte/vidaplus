package com.jefferson.vidaplus.dto.response;

public record UsuarioResponse(Long id,
                              String nome,
                              String email,
                              com.jefferson.vidaplus.model.Perfil perfil,
                              boolean ativo
) {
}