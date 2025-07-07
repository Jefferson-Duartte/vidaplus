package com.jefferson.vidaplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String cpf;
    private String registro;
    private String especialidade;
    private String cargo;
    private String email;
    private String telefone;

    @OneToOne(mappedBy = "profissional")
    private Agenda agenda;

    @OneToMany(mappedBy = "profissional")
    private List<Prontuario> prontuariosEmitidos;

    @OneToMany(mappedBy = "profissional")
    private List<Receita> receitasEmitidas;

}
