package com.siga.proyectoSiga.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.siga.proyectoSiga.model.FormularioMascota;

public interface FormularioMascotaRepository extends JpaRepository<FormularioMascota, Long> {
    List<FormularioMascota> findByUsuarioRun(String run);
}
