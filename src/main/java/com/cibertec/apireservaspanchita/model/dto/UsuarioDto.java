package com.cibertec.apireservaspanchita.model.dto;

import com.cibertec.apireservaspanchita.model.bd.Rol;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private Integer idUsuario;
    private String nombres;
    private String apellidos;
    private String dni;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaNac;
    private String email;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;
}
