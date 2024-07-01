package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.bd.Estado;
import com.cibertec.apireservaspanchita.model.bd.Reserva;
import com.cibertec.apireservaspanchita.model.dto.ReservaDto;
import com.cibertec.apireservaspanchita.model.dto.ReservaDto2;

import java.util.List;
import java.util.Optional;

public interface IReservaService {
    ReservaDto registrar(ReservaDto2 reservaDto);
    ReservaDto buscarPorId(Integer reservaId);
    ReservaDto actualizar(Integer reservaId, ReservaDto reservaDto);
    ReservaDto actualizar2(Integer reservaId, ReservaDto2 reservaDto2);
    Optional<Reserva> listarPorId(Integer reservaId);
    List<ReservaDto2> listarPorIdUsuarioYEstado(Integer idUsuario, Estado estado);
    ReservaDto cancelarReserva(Integer reservaId);
}
