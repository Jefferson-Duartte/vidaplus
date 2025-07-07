package com.jefferson.vidaplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String sexo;
    private String telefone;
    private String email;
    private String endereco;

    @OneToMany(mappedBy = "paciente")
    private List<Prontuario> prontuarios;

    @OneToMany(mappedBy = "paciente")
    private List<Agendamento> agendamentos;

    @OneToMany(mappedBy = "paciente")
    private List<Notificacao> notificacaos;

}
