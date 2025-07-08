package com.jefferson.vidaplus.dto.request;

import java.time.LocalDate;

public record PacienteRequest(String nomeCompleto, LocalDate dataNascimento,
                              String cpf,
                              String sexo,
                              String telefone,
                              String email,
                              String endereco) {
}
