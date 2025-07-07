package com.jefferson.vidaplus.model;

import java.util.List;

public class Profissional {

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
