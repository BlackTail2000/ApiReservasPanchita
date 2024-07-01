package com.cibertec.apireservaspanchita.model.mapper;

import com.cibertec.apireservaspanchita.model.bd.*;
import com.cibertec.apireservaspanchita.model.dto.ReservaDto;
import com.cibertec.apireservaspanchita.model.dto.ReservaDto2;

public class ReservaMapper2 {

    public static ReservaDto2 mapToReservaDto(Reserva reserva) {
        return new ReservaDto2(
                reserva.getNumeroOrden(),
                reserva.getCantidadComensales(),
                reserva.getHorario().getIdHorario(),
                reserva.getSucursal().getIdSucursal(),
                reserva.getUsuario().getIdUsuario(),
                reserva.getMesa().getIdMesa(),
                reserva.getFechaReserva(),
                reserva.getEstado(),
                reserva.getHorario().getHoraInicio(),
                reserva.getHorario().getHoraFin()
        );
    }
}
