package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.bd.Mesa;
import com.cibertec.apireservaspanchita.model.bd.Sucursal;
import com.cibertec.apireservaspanchita.model.dto.MesaDto;
import com.cibertec.apireservaspanchita.model.exception.ResourceNotFoundException;
import com.cibertec.apireservaspanchita.model.mapper.MesaMapper;
import com.cibertec.apireservaspanchita.repository.MesaRepository;
import com.cibertec.apireservaspanchita.repository.SucursalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MesaService implements IMesaService {

    private MesaRepository mesaRepository;
    private SucursalRepository sucursalRepository;

    @Override
    public MesaDto registrar(MesaDto mesaDto) {
        Sucursal sucursal = sucursalRepository.findById(mesaDto.getIdSucursal())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la sucursal con el id: " + mesaDto.getIdSucursal()));
        Mesa mesa = MesaMapper.mapToMesa(mesaDto, sucursal);
        mesaRepository.save(mesa);
        return MesaMapper.mapToMesaDto(mesa);
    }

    @Override
    public MesaDto buscarPorId(Integer idMesa) {
        Mesa mesa = mesaRepository.findById(idMesa)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la mesa con el id: " + idMesa));
        return MesaMapper.mapToMesaDto(mesa);
    }

    @Override
    public MesaDto actualizarMesa(Integer idMesa, MesaDto mesaDto) {
        Mesa mesa = mesaRepository.findById(idMesa)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la mesa con el id: " + idMesa));
        Sucursal sucursal = sucursalRepository.findById(mesaDto.getIdSucursal())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la sucursal con el id: " + mesaDto.getIdSucursal()));

        mesa.setCantSillas(mesaDto.getCantSillas());
        mesa.setSucursal(sucursal);

        Mesa updatedMesa = mesaRepository.save(mesa);
        return MesaMapper.mapToMesaDto(updatedMesa);
    }
}
