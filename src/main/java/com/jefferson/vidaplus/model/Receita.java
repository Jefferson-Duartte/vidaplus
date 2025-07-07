package com.jefferson.vidaplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Profissional profissional;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Prontuario prontuario;

    private LocalDateTime dataHoraEmissao;
    private String medicamento;
    private String posologia;

}
