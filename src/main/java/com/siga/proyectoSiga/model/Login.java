package com.siga.proyectoSiga.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login extends Usuario{

    @Column(name = "user", nullable = false, unique = true)
    private String run;


    @OneToOne
    @JoinColumn(name="user", referencedColumnName = "run", nullable = false, unique = true)
    private Usuario usuario;
    



}
