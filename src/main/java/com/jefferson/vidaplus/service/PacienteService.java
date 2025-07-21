package com.jefferson.vidaplus.service;

import com.jefferson.vidaplus.dto.request.PacienteRequest;
import com.jefferson.vidaplus.dto.response.PacienteResponse;
import com.jefferson.vidaplus.model.Paciente;
import com.jefferson.vidaplus.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    private final ModelMapper mapper;

    public PacienteService(PacienteRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<PacienteResponse> findAll() {
        List<Paciente> pacientes = repository.findAll();
        return pacientes.stream().map((paciente -> mapper.map(paciente, PacienteResponse.class))).toList();
    }

    public PacienteResponse findById(Long id) {
        Paciente paciente = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));
        return mapper.map(paciente, PacienteResponse.class);
    }

    public PacienteResponse create(PacienteRequest pacienteDTO) {
        Paciente paciente = repository.save(mapper.map(pacienteDTO, Paciente.class));
        return mapper.map(paciente, PacienteResponse.class);
    }

    public PacienteResponse update(Long id, PacienteRequest pacienteDTO) {
        Paciente paciente = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado!"));
        mapper.map(pacienteDTO, paciente);
        repository.save(paciente);
        return mapper.map(paciente, PacienteResponse.class);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
