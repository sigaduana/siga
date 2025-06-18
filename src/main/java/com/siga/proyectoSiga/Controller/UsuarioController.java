package com.siga.proyectoSiga.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siga.proyectoSiga.model.Usuario;
import com.siga.proyectoSiga.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //crear un nuevo usuario
    @PostMapping("/crear")   
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
             Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
             return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
        }

    //consultar un usuario por run
    @GetMapping("/{run}") 
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable String run) {
        Usuario usuario = usuarioService.obtenerUsuario(run);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //eliminar un usuario por run
    @DeleteMapping("/{run}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String run) {
        boolean eliminado = usuarioService.eliminarUsuario(run);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

