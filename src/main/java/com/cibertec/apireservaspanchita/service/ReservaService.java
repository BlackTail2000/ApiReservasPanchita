package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.bd.Horario;
import com.cibertec.apireservaspanchita.model.bd.Reserva;
import com.cibertec.apireservaspanchita.model.bd.Sucursal;
import com.cibertec.apireservaspanchita.model.dto.ReservaDto;
import com.cibertec.apireservaspanchita.model.exception.ResourceNotFoundException;
import com.cibertec.apireservaspanchita.model.mapper.HorarioMapper;
import com.cibertec.apireservaspanchita.model.mapper.ReservaMapper;
import com.cibertec.apireservaspanchita.repository.HorarioRepository;
import com.cibertec.apireservaspanchita.repository.ReservaRepository;
import com.cibertec.apireservaspanchita.repository.SucursalRepository;
import com.cibertec.apireservaspanchita.utils.DateUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class ReservaService implements IReservaService {

    private ReservaRepository reservaRepository;
    private SucursalRepository sucursalRepository;
    private HorarioRepository horarioRepository;

    @Override
    public ReservaDto registrar(ReservaDto reservaDto) {
        Sucursal sucursal = sucursalRepository.findById(reservaDto.getIdSucursal())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la sucursal con el id: " + reservaDto.getIdSucursal()));
        Horario horario = horarioRepository.findById(reservaDto.getIdHorario())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró el horario con el id: " + reservaDto.getIdHorario()));
        reservaDto.setFechaReserva(reservaDto.getFechaReserva());
        Reserva reserva = ReservaMapper.mapToReserva(reservaDto, horario, sucursal);
        reservaRepository.save(reserva);
        return ReservaMapper.mapToReservaDto(reserva);
    }

    @Override
    public ReservaDto buscarPorId(Integer reservaId) {
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la reserva con el id: " + reservaId));
        return ReservaMapper.mapToReservaDto(reserva);
    }

    @Override
    public ReservaDto actualizar(Integer reservaId, ReservaDto reservaDto) {
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la reserva con el id: " + reservaId));
        Sucursal sucursal = sucursalRepository.findById(reservaDto.getIdSucursal())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la sucursal con el id: " + reservaDto.getIdSucursal()));
        Horario horario = horarioRepository.findById(reservaDto.getIdHorario())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró el horario con el id: " + reservaDto.getIdHorario()));

        reserva.setCantidadComensales(reservaDto.getCantidadComensales());
        reserva.setHorario(horario);
        reserva.setSucursal(sucursal);
        reserva.setFechaReserva(reservaDto.getFechaReserva());
        reserva.setEstado(reservaDto.getEstado());

        Reserva updatedReserva = reservaRepository.save(reserva);
        return ReservaMapper.mapToReservaDto(updatedReserva);
    }
}
