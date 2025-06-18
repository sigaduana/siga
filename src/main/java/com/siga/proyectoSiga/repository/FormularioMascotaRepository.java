package com.siga.proyectoSiga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siga.proyectoSiga.model.FormularioMascota;

public interface FormularioMascotaRepository extends JpaRepository<FormularioMascota, Long> {

    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar por nombre de mascota o especie

}
