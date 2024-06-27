package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.dto.MesaDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

public interface IMesaService {
    MesaDto registrar(MesaDto mesaDto);
    MesaDto buscarPorId(Integer idMesa);
    MesaDto actualizarMesa(Integer idMesa, MesaDto mesaDto);
    Integer obtenerNroMesasPorSucursal(Integer idSucursal);
    Integer obtenerNroMesasOcupadasPorFechaYSucursal(Date fecha, Integer idSucursal);
    Integer obtenerNroMesasDisponiblesPorFechaYSucursal(Date fecha, Integer idSucursal);
}
