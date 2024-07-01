package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.bd.*;
import com.cibertec.apireservaspanchita.model.dto.*;
import com.cibertec.apireservaspanchita.model.exception.ResourceNotFoundException;
import com.cibertec.apireservaspanchita.model.mapper.ReservaMapper;
import com.cibertec.apireservaspanchita.model.mapper.ReservaMapper2;
import com.cibertec.apireservaspanchita.repository.*;
import com.cibertec.apireservaspanchita.utils.DateUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservaService implements IReservaService {

    private ReservaRepository reservaRepository;
    private SucursalRepository sucursalRepository;
    private HorarioRepository horarioRepository;
    private UsuarioRepository usuarioRepository;
    private MesaRepository mesaRepository;
    private IMesaService mesaService;

    @Override
    public ReservaDto2 registrar(ReservaDto2 reservaDto2) {
        Sucursal sucursal = sucursalRepository.findById(reservaDto2.getIdSucursal())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la sucursal con el id: " + reservaDto2.getIdSucursal()));
        Usuario usuario = usuarioRepository.findById(reservaDto2.getIdUsuario())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró el usuario con el id: " + reservaDto2.getIdUsuario()));

        Horario horario = new Horario(null, reservaDto2.getHoraInicio(), null, sucursal);
        horario = horarioRepository.save(horario);
        reservaDto2.setIdHorario(horario.getIdHorario());

        int cantidadComensales = reservaDto2.getCantidadComensales();
        int mesasNecesarias = cantidadComensales % 4 == 0 ? cantidadComensales / 4 : cantidadComensales / 4 + 1;

        Mesa mesa = new Mesa(null, mesasNecesarias, cantidadComensales, sucursal);
        mesa = mesaRepository.save(mesa);
        reservaDto2.setIdMesa(mesa.getIdMesa());
        Reserva reserva = ReservaMapper.mapToReserva(reservaDto2, horario, sucursal, usuario, mesa);
        reserva.setFechaReserva(DateUtils.addOneDay(reserva.getFechaReserva()));
        reserva = reservaRepository.save(reserva);
        reservaDto2.setNumeroOrden(reserva.getNumeroOrden());
        return reservaDto2;
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
        Mesa mesa = mesaRepository.findById(reservaDto.getIdMesa())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la mesa con el id: " + reservaDto.getIdMesa()));
        reserva.setCantidadComensales(reservaDto.getCantidadComensales());
        reserva.setHorario(horario);
        reserva.setSucursal(sucursal);
        reserva.setMesa(mesa);
        reserva.setFechaReserva(reservaDto.getFechaReserva());
        reserva.setEstado(reservaDto.getEstado());

        Reserva updatedReserva = reservaRepository.save(reserva);
        return ReservaMapper.mapToReservaDto(updatedReserva);
    }

    @Override
    public Optional<Reserva> listarPorId(Integer reservaId) {
         Optional<Reserva> r =  reservaRepository.findById(reservaId);
         return r;
    }

    @Override
    public List<ReservaDto2> listarPorIdUsuarioYEstado(Integer idUsuario, Estado estado) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró al usuario con id:" + idUsuario));
        List<Reserva> listaReservas = reservaRepository.findAllByUsuario_idUsuarioAndEstado(idUsuario, estado);
        return listaReservas.stream().map(ReservaMapper2::mapToReservaDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReservaDto cancelarReserva(Integer reservaId) {
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la reserva con el id: " + reservaId));
        reserva.setEstado(Estado.CANCELADO);
        Reserva updatedReserva = reservaRepository.save(reserva);
        return ReservaMapper.mapToReservaDto(updatedReserva);
    }

    /*Metodo que solo setea los campos necesarios para el finalizar reserva
        agregando un campo mas a diferencia del anterior, que ahora tendra el HoraFin*/
    @Override
    public ReservaDto actualizar2(Integer reservaId, ReservaDto2 reservaDto2) {
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la reserva con el id: " + reservaId));
        Horario horario = horarioRepository.findById(reservaDto2.getIdHorario())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró el horario con el id: " + reservaDto2.getIdHorario()));
        horario.setHoraFin(reservaDto2.getHoraFin());
        reserva.setHorario(horario);
        reserva.setEstado(reservaDto2.getEstado());
        Reserva updatedReserva = reservaRepository.save(reserva);
        return ReservaMapper.mapToReservaDto(updatedReserva);
    }
}
