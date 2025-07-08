//package com.jefferson.vidaplus.service;
//
//import com.jefferson.vidaplus.dto.request.PacienteRequest;
//import com.jefferson.vidaplus.dto.response.PacienteResponse;
//import com.jefferson.vidaplus.mapper.PacienteMapper;
//import com.jefferson.vidaplus.model.Paciente;
//import com.jefferson.vidaplus.repository.PacienteRepository;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class PacienteService {
//
//    private final PacienteRepository repository;
//    private final PacienteMapper mapper;
//
//    public PacienteService(PacienteRepository repository, PacienteMapper mapper) {
//        this.repository = repository;
//        this.mapper = mapper;
//    }
//
//    public List<PacienteResponse> findAll() {
//        return mapper.toResponseList(repository.findAll());
//    }
//
//    public PacienteResponse findById(Long id) {
//        Paciente paciente = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));
//        return mapper.toResponse(paciente);
//    }
//
//    public PacienteResponse create(PacienteRequest pacienteDTO) {
//        Paciente paciente = mapper.mapToEntity(pacienteDTO);
//        return mapper.toResponse(repository.save(paciente));
//    }
//
//
//}
