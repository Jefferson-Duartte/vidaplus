package com.jefferson.vidaplus.dto.response;

import com.jefferson.vidaplus.model.Agenda;
import com.jefferson.vidaplus.model.Prontuario;
import com.jefferson.vidaplus.model.Receita;
import lombok.Data;

import java.util.List;

@Data
public class ProfissionalResponse {
    private Long id;
    private String nomeCompleto;
    private String cpf;
    private String registro;
    private String especialidade;
    private String cargo;
    private String email;
    private String telefone;

    private Agenda agenda;

    private List<Prontuario> prontuariosEmitidos;

    private List<Receita> receitasEmitidas;
}
