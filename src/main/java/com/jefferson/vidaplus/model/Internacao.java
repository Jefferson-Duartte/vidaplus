package com.jefferson.vidaplus.model;

import java.time.LocalDateTime;

public class Internacao {

    private Long id;
    private Paciente paciente;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private Leito leito;
    private String motivo;
    private StatusInternacao status;

}
