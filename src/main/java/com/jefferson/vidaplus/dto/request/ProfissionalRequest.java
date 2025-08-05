package com.jefferson.vidaplus.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProfissionalRequest {

    @NotNull
    private String nomeCompleto;

    @NotNull
    private String cpf;
    @NotNull
    private String registro;
    @NotNull
    private String especialidade;
    @NotNull
    private String cargo;
    @NotNull
    private String email;
    @NotNull
    private String telefone;
}
