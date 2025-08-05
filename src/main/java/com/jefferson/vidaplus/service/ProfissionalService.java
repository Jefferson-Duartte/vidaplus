package com.jefferson.vidaplus.service;

import com.jefferson.vidaplus.dto.request.ProfissionalRequest;
import com.jefferson.vidaplus.dto.response.ProfissionalResponse;
import com.jefferson.vidaplus.model.Profissional;
import com.jefferson.vidaplus.repository.ProfissionalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalService {

    private final ProfissionalRepository repository;

    private final ModelMapper mapper;

    public ProfissionalService(ProfissionalRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ProfissionalResponse> findAll() {
        List<Profissional> profissionals = repository.findAll();
        return profissionals.stream().map((profissional -> mapper.map(profissional, ProfissionalResponse.class))).toList();
    }

    public ProfissionalResponse findById(Long id) {
        Profissional profissional = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));
        return mapper.map(profissional, ProfissionalResponse.class);
    }

    public ProfissionalResponse create(ProfissionalRequest profissionalDTO) {
        Profissional profissional = repository.save(mapper.map(profissionalDTO, Profissional.class));
        return mapper.map(profissional, ProfissionalResponse.class);
    }

    public ProfissionalResponse update(Long id, ProfissionalRequest profissionalDTO) {
        Profissional profissional = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Profissional não encontrado!"));
        mapper.map(profissionalDTO, profissional);
        repository.save(profissional);
        return mapper.map(profissional, ProfissionalResponse.class);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
