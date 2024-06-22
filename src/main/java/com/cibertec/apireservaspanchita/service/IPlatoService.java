package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.bd.Plato;
import com.cibertec.apireservaspanchita.model.dto.PlatoDto;

import java.util.List;

public interface IPlatoService {
    PlatoDto registrar(PlatoDto platoDto);
    List<PlatoDto> listarlosTodos();
    PlatoDto buscarPorId(Integer platoId);
    PlatoDto actualizar(Integer platoId, PlatoDto platoDto);
}
