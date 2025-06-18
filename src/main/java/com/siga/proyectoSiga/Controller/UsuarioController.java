package com.siga.proyectoSiga.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.siga.proyectoSiga.model.Usuario;
import com.siga.proyectoSiga.service.UsuarioService;

import com.siga.proyectoSiga.model.Usuario;
import com.siga.proyectoSiga.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private  UsuarioService usuarioService;

    //crear un nuevo usuario
    @PostMapping("/crear")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioService.crearUsuario(usuario);
    }
    

    //consultar un usuario por run
    @GetMapping("/{run}") 
    public Usuario obtenerUsuarioPorRun(@PathVariable String run){
        return usuarioService.obtenerUsuarioPorRun(run);
    }

    //eliminar un usuario por run
    @DeleteMapping("/{run}")
    public void eliminarUsuario(@PathVariable String run){
        usuarioService.eliminarUsuarioPorRun(run);
    }
}


