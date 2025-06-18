package com.siga.proyectoSiga.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

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

    //actualizar un usuario por run
    @PutMapping("/{run}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable String run, @RequestBody Usuario usuario) {
        Usuario usuarioActualizado = usuarioService.actualizarUsuario(run, usuario);
        if (usuarioActualizado != null) {
            return ResponseEntity.ok(usuarioActualizado);
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

    //listar todos los usuarios
    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }
