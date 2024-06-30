package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.dto.HorarioDto;

import java.util.List;

public interface IHorarioService {
    HorarioDto registrar(HorarioDto horarioDto);
    List<HorarioDto> listarPorSucursal(Integer sucursalId);
    HorarioDto buscarPorId(Integer horarioId);
    Integer obtenerUltimoIdHorario();
}
