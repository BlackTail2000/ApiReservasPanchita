package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.dto.ReservaDto;

public interface IReservaService {
    ReservaDto registrar(ReservaDto reservaDto);
    ReservaDto buscarPorId(Integer reservaId);
    ReservaDto actualizar(Integer reservaId, ReservaDto reservaDto);
}
