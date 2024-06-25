package com.cibertec.apireservaspanchita.model.mapper;

import com.cibertec.apireservaspanchita.model.bd.Categoria;
import com.cibertec.apireservaspanchita.model.bd.Menu;
import com.cibertec.apireservaspanchita.model.bd.Plato;
import com.cibertec.apireservaspanchita.model.dto.PlatoDto;

public class PlatoMapper {

    public static PlatoDto mapToPlatoDto(Plato plato) {
        return new PlatoDto(
                plato.getIdPlato(),
                plato.getNombrePlato(),
                plato.getFoto(),
                plato.getMenu().getIdMenu(),
                plato.getCategoria().getIdCategoria()
        );
    }

    public static Plato mapToPlato(PlatoDto platoDto, Menu menu, Categoria categoria) {
        return new Plato(
                platoDto.getIdPlato(),
                platoDto.getNombrePlato(),
                platoDto.getFoto(),
                menu,
                categoria
        );
    }
}
