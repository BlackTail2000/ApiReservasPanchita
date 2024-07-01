package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.bd.Mesa;
import com.cibertec.apireservaspanchita.model.dto.MesaDto;

import java.util.Date;
import java.util.List;

public interface IMesaService {
    MesaDto registrar(MesaDto mesaDto);
    MesaDto buscarPorId(Integer idMesa);
    MesaDto actualizarMesa(Integer idMesa, MesaDto mesaDto);
    Integer obtenerNroMesasOcupadasPorFechaYSucursal(Date fecha, Integer idSucursal);
    Integer obtenerNroMesasDisponiblesPorFechaYSucursal(Date fecha, Integer idSucursal);

}
