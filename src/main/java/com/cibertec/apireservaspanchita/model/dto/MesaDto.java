package com.cibertec.apireservaspanchita.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MesaDto {
    private Integer idMesa;
    private Integer cantSillas;
    private Integer idSucursal;
}
