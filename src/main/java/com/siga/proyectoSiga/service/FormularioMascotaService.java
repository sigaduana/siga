package com.siga.proyectoSiga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siga.proyectoSiga.model.FormularioMascota;
import com.siga.proyectoSiga.repository.FormularioMascotaRepository;

@Service
public class FormularioMascotaService {

    @Autowired
    private FormularioMascotaRepository formularioMascotaRepository;

    // Métodos crear
    public FormularioMascota crearFormularioMascota(FormularioMascota formularioMascota) {
        return formularioMascotaRepository.save(formularioMascota);
    }

    // Método consultar
    public FormularioMascota obtenerFormularioMascota(Long id) {
        return formularioMascotaRepository.findById(id).orElse(null);
    }

    // Método actualizar
    public FormularioMascota actualizarFormularioMascota(Long id, FormularioMascota formularioMascota) {
        if (formularioMascotaRepository.existsById(id)) {
            formularioMascota.setId(id);
            return formularioMascotaRepository.save(formularioMascota);
        }
        return null;
    }

    // Método eliminar
    public boolean eliminarFormularioMascota(Long id) {
        if (formularioMascotaRepository.existsById(id)) {
            formularioMascotaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Método listar
    public List<FormularioMascota> listarFormulariosMascota() {
        return formularioMascotaRepository.findAll();
    }

}
