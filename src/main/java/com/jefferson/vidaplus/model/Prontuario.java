package com.jefferson.vidaplus.model;

import java.time.LocalDateTime;
import java.util.List;

public class Prontuario {

    private Long id;
    private Paciente paciente;
    private Profissional profissional;
    private LocalDateTime dataHora;
    private String problema;
    private String historico;
    private String diagnostico;
    private List<Receita> receitas;

}
