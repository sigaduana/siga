package com.siga.proyectoSiga.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "formulario_mascota")
@NoArgsConstructor
@AllArgsConstructor
public class FormularioMascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_mascota", nullable = false)
    private String nombre_mascota;

    @Column(name = "especie", nullable = false)
    private String especie;

    @Column(name = "raza", nullable = false)
    private String raza;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "edad", nullable = false)
    private String edad;

    @Column(name = "vacuna", nullable = false)
    private Boolean vacuna;

    @ManyToOne
    @JoinColumn(name = "usuario_run", nullable = false)
    private Usuario usuario;
}
