package com.jefferson.vidaplus.service;

import com.jefferson.vidaplus.model.Paciente;
import com.jefferson.vidaplus.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<Paciente> getAll(){
        return repository.findAll();
    }

}
