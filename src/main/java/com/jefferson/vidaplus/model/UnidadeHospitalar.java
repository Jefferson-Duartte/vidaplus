package com.jefferson.vidaplus.model;

import java.util.List;

public class UnidadeHospitalar {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private List<Profissional> profissionais;
    private List<Paciente> pacientes;
    private List<Leito> leitos;

}
