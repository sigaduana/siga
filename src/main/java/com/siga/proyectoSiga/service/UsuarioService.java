package com.siga.proyectoSiga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siga.proyectoSiga.model.Usuario;
import com.siga.proyectoSiga.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired // 
    private UsuarioRepository usuarioRepository;

    // Método para guardar un usuario
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    
    }
    // Método para buscar un usuario por RUN
    public Usuario obtenerUsuarioPorRun(String run) {
        return usuarioRepository.findById(run).orElse(null);
    }

    // metodo para eliminar un usuario por RUN
    public void eliminarUsuarioPorRun(String run) {
        usuarioRepository.deleteById(run);
    }
}

