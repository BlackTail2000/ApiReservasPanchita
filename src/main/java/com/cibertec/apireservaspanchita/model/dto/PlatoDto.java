package com.cibertec.apireservaspanchita.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDto {
    private Integer idPlato;
    private String nombrePlato;
    private Integer idMenu;
    private Integer idCategoria;
}
