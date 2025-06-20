package com.siga.proyectoSiga.controller;

import java.util.List;

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

import com.siga.proyectoSiga.model.FormularioMascota;
import com.siga.proyectoSiga.service.FormularioMascotaService;

@RestController
@RequestMapping("/formulario-mascota")
public class FormularioMascotaController {

    @Autowired
    private FormularioMascotaService formularioMascotaService;
    
    //crear un nuevo formulario de mascota
    @PostMapping("/crear")
    public ResponseEntity<FormularioMascota> crearFormularioMascota(@RequestBody FormularioMascota formularioMascota) {
         FormularioMascota nuevoFormulario = formularioMascotaService.crearFormularioMascota(formularioMascota);
         return ResponseEntity.status(HttpStatus.CREATED).body(nuevoFormulario);
        }

     //consultar un formulario de mascota por id
     @GetMapping("/{id}")
     public ResponseEntity<FormularioMascota> obtenerFormularioMascota(@PathVariable Long id) {
         FormularioMascota formularioMascota = formularioMascotaService.obtenerFormularioMascota(id);
         if (formularioMascota != null) {
             return ResponseEntity.ok(formularioMascota);
         } else {
             return ResponseEntity.notFound().build();
         }
     }

     //actualizar un formulario de mascota por id
     @PutMapping("/{id}")
     public ResponseEntity<FormularioMascota> actualizarFormularioMascota(@PathVariable Long id, @RequestBody FormularioMascota formularioMascota) {
         FormularioMascota formularioActualizado = formularioMascotaService.actualizarFormularioMascota(id, formularioMascota);
         if (formularioActualizado != null) {
             return ResponseEntity.ok(formularioActualizado);
         } else {
             return ResponseEntity.notFound().build();
         }
     }
     //eliminar un formulario de mascota por id
     @DeleteMapping("/{id}")
     public ResponseEntity<Void> eliminarFormularioMascota(@PathVariable Long id) {
         boolean eliminado = formularioMascotaService.eliminarFormularioMascota(id);
         if (eliminado) {
             return ResponseEntity.noContent().build();
         } else {
             return ResponseEntity.notFound().build();
         }
     }
        //listar todos los formularios de mascota
    @GetMapping("/listar")
    public ResponseEntity<List<FormularioMascota>> listarFormulariosMascota() {
        List<FormularioMascota> formulariosMascota = formularioMascotaService.listarFormulariosMascota();
        return ResponseEntity.ok(formulariosMascota);
    }

    //listar mascotas por usuario
    @GetMapping("/usuario/{run}")
    public ResponseEntity<List<FormularioMascota>> listarFormulariosMascotaPorUsuario(@PathVariable String run) {
        List<FormularioMascota> formulariosMascota = formularioMascotaService.listarFormulariosMascotaPorUsuario(run);
        return ResponseEntity.ok(formulariosMascota);
    }

    

}
