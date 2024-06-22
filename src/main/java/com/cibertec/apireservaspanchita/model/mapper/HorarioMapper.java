package com.cibertec.apireservaspanchita.model.mapper;

import com.cibertec.apireservaspanchita.model.bd.Horario;
import com.cibertec.apireservaspanchita.model.bd.Sucursal;
import com.cibertec.apireservaspanchita.model.dto.HorarioDto;

public class HorarioMapper {

    public static HorarioDto mapToHorarioDto(Horario horario) {
        return new HorarioDto(
                horario.getIdHorario(),
                horario.getFecha(),
                horario.getHoraInicio(),
                horario.getHoraFin(),
                horario.getSucursal().getIdSucursal()
        );
    }

    public static Horario mapToHorario(HorarioDto horarioDto, Sucursal sucursal) {
        return new Horario(
                horarioDto.getIdHorario(),
                horarioDto.getFecha(),
                horarioDto.getHoraInicio(),
                horarioDto.getHoraFin(),
                sucursal
        );
    }
}
