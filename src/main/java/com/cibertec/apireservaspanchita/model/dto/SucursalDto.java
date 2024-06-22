package com.cibertec.apireservaspanchita.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SucursalDto {
    private Integer idSucursal;
    private String nombreSucursal;
    private String direccion;
    private Double lat;
    private Double longitud;
    private String foto;
    private Integer cantidadMesa;
}
