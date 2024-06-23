package com.cibertec.apireservaspanchita.model.mapper;

import com.cibertec.apireservaspanchita.model.bd.Horario;
import com.cibertec.apireservaspanchita.model.bd.Reserva;
import com.cibertec.apireservaspanchita.model.bd.Sucursal;
import com.cibertec.apireservaspanchita.model.dto.ReservaDto;

public class ReservaMapper {

    public static ReservaDto mapToReservaDto(Reserva reserva) {
        return new ReservaDto(
                reserva.getNumeroOrden(),
                reserva.getCantidadComensales(),
                reserva.getHorario().getIdHorario(),
                reserva.getSucursal().getIdSucursal(),
                reserva.getFechaReserva(),
                reserva.getEstado()
        );
    }

    public static Reserva mapToReserva(ReservaDto reservaDto, Horario horario, Sucursal sucursal) {
        return new Reserva(
                reservaDto.getNumeroOrden(),
                reservaDto.getCantidadComensales(),
                horario,
                sucursal,
                reservaDto.getFechaReserva(),
                reservaDto.getEstado()
        );
    }
}
