package com.jefferson.vidaplus.repository;

import com.jefferson.vidaplus.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
