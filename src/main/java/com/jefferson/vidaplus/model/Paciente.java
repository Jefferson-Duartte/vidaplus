package com.jefferson.vidaplus.model;

import java.time.LocalDate;
import java.util.List;

public class Paciente {

    private Long id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String sexo;
    private String telefone;
    private String email;
    private String endereco;
    private List<Prontuario> prontuarios;
    private List<Agendamento> agendamentos;
    private List<Notificacao> notificacaos;

}
