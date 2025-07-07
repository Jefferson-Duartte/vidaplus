package com.jefferson.vidaplus.model;

import java.time.LocalDateTime;

public class VideoConsulta {

    private Long id;
    private Paciente paciente;
    private Profissional profissional;
    private LocalDateTime dataHora;
    private String linkAcesso;
    private boolean realizada;
    private Prontuario prontuario;

}
