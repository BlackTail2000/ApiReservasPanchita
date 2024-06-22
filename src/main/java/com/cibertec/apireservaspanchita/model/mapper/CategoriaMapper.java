package com.cibertec.apireservaspanchita.model.mapper;

import com.cibertec.apireservaspanchita.model.bd.Categoria;
import com.cibertec.apireservaspanchita.model.dto.CategoriaDto;

public class CategoriaMapper {

    public static CategoriaDto mapToCategoriaDto(Categoria categoria) {
        return new CategoriaDto(
                categoria.getIdCategoria(),
                categoria.getNombreCategoria()
        );
    }

    public static Categoria mapToCategoria(CategoriaDto categoriaDto) {
        return new Categoria(
                categoriaDto.getIdCategoria(),
                categoriaDto.getNombreCategoria()
        );
    }
}
