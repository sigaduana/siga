package com.siga.proyectoSiga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siga.proyectoSiga.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {


}
