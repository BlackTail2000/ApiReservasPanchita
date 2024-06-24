package com.cibertec.apireservaspanchita.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String nombres;
    private String apellidos;
    private String dni;
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    private String email;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;
}
