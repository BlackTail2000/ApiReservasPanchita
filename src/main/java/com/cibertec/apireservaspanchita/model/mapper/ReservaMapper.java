package com.cibertec.apireservaspanchita.model.mapper;

import com.cibertec.apireservaspanchita.model.bd.*;
import com.cibertec.apireservaspanchita.model.dto.ReservaDto;

public class ReservaMapper {

    public static ReservaDto mapToReservaDto(Reserva reserva) {
        return new ReservaDto(
                reserva.getNumeroOrden(),
                reserva.getCantidadComensales(),
                reserva.getHorario().getIdHorario(),
                reserva.getSucursal().getIdSucursal(),
                reserva.getUsuario().getIdUsuario(),
                reserva.getMesa().getIdMesa(),
                reserva.getFechaReserva(),
                reserva.getEstado()
        );
    }

    public static Reserva mapToReserva(ReservaDto reservaDto, Horario horario, Sucursal sucursal, Usuario usuario, Mesa mesa) {
        return new Reserva(
                reservaDto.getNumeroOrden(),
                reservaDto.getCantidadComensales(),
                horario,
                sucursal,
                usuario,
                mesa,
                reservaDto.getFechaReserva(),
                reservaDto.getEstado()
        );
    }
}
