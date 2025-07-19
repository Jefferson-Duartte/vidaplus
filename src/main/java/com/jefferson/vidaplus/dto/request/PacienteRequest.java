package com.jefferson.vidaplus.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PacienteRequest{
        private String nomeCompleto;
        private LocalDate dataNascimento;
        private String cpf;
        private String sexo;
        private String telefone;
        private String email;
        private String endereco;
}
