package com.cibertec.apireservaspanchita.model.mapper;

import com.cibertec.apireservaspanchita.model.bd.Mesa;
import com.cibertec.apireservaspanchita.model.bd.Sucursal;
import com.cibertec.apireservaspanchita.model.dto.MesaDto;

public class MesaMapper {

    public static MesaDto mapToMesaDto(Mesa mesa) {
        return new MesaDto(
                mesa.getIdMesa(),
                mesa.getCantSillas(),
                mesa.getSucursal().getIdSucursal()
        );
    }
    public static Mesa mapToMesa(MesaDto mesaDto, Sucursal sucursal) {
        return new Mesa(
                mesaDto.getIdMesa(),
                mesaDto.getCantSillas(),
                sucursal
        );
    }
}
