package com.jefferson.vidaplus.model;

import java.time.LocalDateTime;

public class Notificacao {

    private Long id;
    private Paciente paciente;
    private String mensagem;
    private LocalDateTime dataEnvio;
    private boolean lida;

}
