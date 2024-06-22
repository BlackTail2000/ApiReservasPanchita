package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.dto.SucursalDto;

import java.util.List;

public interface ISucursalService {
    SucursalDto registrar(SucursalDto sucursalDto);
    SucursalDto buscarPorId(Integer sucursalId);
    List<SucursalDto> listarlasTodas();
    SucursalDto actualizar(Integer sucursalId, SucursalDto sucursalDto);
}
