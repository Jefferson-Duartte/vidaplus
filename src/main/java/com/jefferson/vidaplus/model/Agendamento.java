package com.jefferson.vidaplus.model;

import java.time.LocalDateTime;

public class Agendamento {

    private Long id;
    private Paciente paciente;
    private Profissional profissional;
    private LocalDateTime dataHora;
    private TipoAgendamento tipo;
    private StatusAgendamento status;

}
