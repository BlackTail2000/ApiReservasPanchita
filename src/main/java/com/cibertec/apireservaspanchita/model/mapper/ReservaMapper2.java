package com.cibertec.apireservaspanchita.model.mapper;

import com.cibertec.apireservaspanchita.model.bd.Reserva;
import com.cibertec.apireservaspanchita.model.dto.ReservaDto3;

public class ReservaMapper2 {
    public static ReservaDto3 mapToReservaDto(Reserva reserva) {
        return new ReservaDto3(
                reserva.getNumeroOrden(),
                reserva.getCantidadComensales(),
                HorarioMapper.mapToHorarioDto(reserva.getHorario()),
                SucursalMapper.mapToSucursalDto(reserva.getSucursal()),
                UsuarioMapper.mapToUsuarioDto(reserva.getUsuario()),
                MesaMapper.mapToMesaDto(reserva.getMesa()),
                reserva.getFechaReserva(),
                reserva.getEstado()
        );
    }
}
