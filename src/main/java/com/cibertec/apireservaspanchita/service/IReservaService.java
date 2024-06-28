package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.dto.ReservaDto;
import com.cibertec.apireservaspanchita.model.dto.ReservaDto2;

public interface IReservaService {
    ReservaDto registrar(ReservaDto2 reservaDto);
    ReservaDto buscarPorId(Integer reservaId);
    ReservaDto actualizar(Integer reservaId, ReservaDto reservaDto);
}
