package com.jefferson.vidaplus.dto.response;

import java.time.LocalDate;

public record PacienteResponse(Long id, String nomeCompleto, LocalDate dataNascimento,
                               String cpf,
                               String sexo,
                               String telefone,
                               String email,
                               String endereco) {
}
