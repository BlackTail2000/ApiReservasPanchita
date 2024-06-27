package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.bd.Sucursal;
import com.cibertec.apireservaspanchita.model.dto.SucursalDto;
import com.cibertec.apireservaspanchita.model.exception.ResourceNotFoundException;
import com.cibertec.apireservaspanchita.model.mapper.SucursalMapper;
import com.cibertec.apireservaspanchita.repository.SucursalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SucursalService implements ISucursalService {

    private SucursalRepository sucursalRepository;

    @Override
    public SucursalDto registrar(SucursalDto sucursalDto) {
        Sucursal sucursal = SucursalMapper.mapToSucursal(sucursalDto);
        sucursalRepository.save(sucursal);
        return SucursalMapper.mapToSucursalDto(sucursal);
    }

    @Override
    public SucursalDto buscarPorId(Integer sucursalId) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la sucursal con el id: " + sucursalId));
        return SucursalMapper.mapToSucursalDto(sucursal);
    }

    @Override
    public List<SucursalDto> listarlasTodas() {
        List<Sucursal> listaSucursales = sucursalRepository.findAll();
        return listaSucursales.stream().map(SucursalMapper::mapToSucursalDto)
                .collect(Collectors.toList());
    }

    @Override
    public SucursalDto actualizar(Integer sucursalId, SucursalDto sucursalDto) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la sucursal con el id: " + sucursalId));

        sucursal.setNombreSucursal(sucursalDto.getNombreSucursal());
        sucursal.setDireccion(sucursalDto.getDireccion());
        sucursal.setLat(sucursalDto.getLat());
        sucursal.setLongitud(sucursalDto.getLongitud());
        sucursal.setFoto(sucursalDto.getFoto());

        Sucursal updatedSucursal = sucursalRepository.save(sucursal);
        return SucursalMapper.mapToSucursalDto(updatedSucursal);
    }
}
