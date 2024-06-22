package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.dto.CategoriaDto;

import java.util.List;

public interface ICategoriaService {
    CategoriaDto registrar(CategoriaDto categoriaDto);
    List<CategoriaDto> listarlasTodas();
    CategoriaDto buscarPorId(Integer categoriaId);
    CategoriaDto actualizar(Integer categoriaId, CategoriaDto categoriaDto);
    void eliminar(Integer categoriaId);
}
