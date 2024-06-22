package com.cibertec.apireservaspanchita.model.bd;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSucursal;
    private String nombreSucursal;
    private String direccion;
    private Double lat;
    private Double longitud;
    private String foto;
    private Integer cantidadMesa;
}
