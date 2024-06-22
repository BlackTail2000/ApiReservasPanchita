package com.cibertec.apireservaspanchita.model.mapper;

import com.cibertec.apireservaspanchita.model.bd.Sucursal;
import com.cibertec.apireservaspanchita.model.dto.SucursalDto;

public class SucursalMapper {

    public static SucursalDto mapToSucursalDto(Sucursal sucursal) {
        return new SucursalDto(
                sucursal.getIdSucursal(),
                sucursal.getNombreSucursal(),
                sucursal.getDireccion(),
                sucursal.getLat(),
                sucursal.getLongitud(),
                sucursal.getFoto(),
                sucursal.getCantidadMesa()
        );
    }

    public static Sucursal mapToSucursal(SucursalDto sucursalDto) {
        return new Sucursal(
                sucursalDto.getIdSucursal(),
                sucursalDto.getNombreSucursal(),
                sucursalDto.getDireccion(),
                sucursalDto.getLat(),
                sucursalDto.getLongitud(),
                sucursalDto.getFoto(),
                sucursalDto.getCantidadMesa()
        );
    }
}
