package com.jefferson.vidaplus.mapper;

import com.jefferson.vidaplus.dto.request.PacienteRequest;
import com.jefferson.vidaplus.dto.response.PacienteResponse;
import com.jefferson.vidaplus.model.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface PacienteMapper {
    @Mapping(target = "id", ignore = true)
    Paciente mapToEntity(PacienteRequest dto);

    PacienteResponse toResponse(Paciente paciente);

    List<PacienteResponse> toResponseList(List<Paciente> list);
}
