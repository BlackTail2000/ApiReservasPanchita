package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.bd.Horario;
import com.cibertec.apireservaspanchita.model.bd.Sucursal;
import com.cibertec.apireservaspanchita.model.dto.HorarioDto;
import com.cibertec.apireservaspanchita.model.exception.ResourceNotFoundException;
import com.cibertec.apireservaspanchita.model.mapper.HorarioMapper;
import com.cibertec.apireservaspanchita.repository.HorarioRepository;
import com.cibertec.apireservaspanchita.repository.SucursalRepository;
import com.cibertec.apireservaspanchita.utils.DateUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HorarioService implements IHorarioService {

    private HorarioRepository horarioRepository;
    private SucursalRepository sucursalRepository;

    @Override
    public HorarioDto registrar(HorarioDto horarioDto) {
        Sucursal sucursal = sucursalRepository.findById(horarioDto.getIdSucursal())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la sucursal con el id: " + horarioDto.getIdSucursal()));
        Horario horario = HorarioMapper.mapToHorario(horarioDto, sucursal);
        horarioRepository.save(horario);
        return HorarioMapper.mapToHorarioDto(horario);
    }

    @Override
    public List<HorarioDto> listarPorSucursal(Integer sucursalId) {
        List<Horario> listaHorarios = horarioRepository.findAllBySucursalId(sucursalId);
        return listaHorarios.stream().map(HorarioMapper::mapToHorarioDto)
                .collect(Collectors.toList());
    }

    @Override
    public HorarioDto buscarPorId(Integer horarioId) {
        Horario horario = horarioRepository.findById(horarioId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró el horario con el id: " + horarioId));
        return HorarioMapper.mapToHorarioDto(horario);
    }
}
