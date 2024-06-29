package com.cibertec.apireservaspanchita.controller;

import com.cibertec.apireservaspanchita.model.bd.Estado;
import com.cibertec.apireservaspanchita.model.bd.Reserva;
import com.cibertec.apireservaspanchita.model.dto.ReservaDto;
import com.cibertec.apireservaspanchita.model.dto.ReservaDto2;
import com.cibertec.apireservaspanchita.model.dto.ReservaDto3;
import com.cibertec.apireservaspanchita.service.IReservaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reserva")
@AllArgsConstructor
public class ReservaController {

    private IReservaService iReservaService;

    @PostMapping
    public ResponseEntity<ReservaDto> registrar(@RequestBody ReservaDto2 reservaDto2) {
        ReservaDto reservaRegister = iReservaService.registrar(reservaDto2);
        return new ResponseEntity<>(reservaRegister, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ReservaDto> buscarPorId(@PathVariable("id") Integer reservaId) {
        ReservaDto reservaDto = iReservaService.buscarPorId(reservaId);
        return ResponseEntity.ok(reservaDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<ReservaDto> actualizar(@PathVariable("id") Integer reservaId,
                                                 @RequestBody ReservaDto updatedReserva) {
        ReservaDto reservaDto = iReservaService.actualizar(reservaId, updatedReserva);
        return ResponseEntity.ok(reservaDto);
    }

    @GetMapping("/usuario/{id}/{estado}")
    public ResponseEntity<List<ReservaDto3>> listarReservasPorUsuarioYEstado(@PathVariable("id") Integer idUsuario,
                                                                       @PathVariable("estado")Estado estado) {
        List<ReservaDto3> listaReservas = iReservaService.listarPorIdUsuarioYEstado(idUsuario, estado);
        return ResponseEntity.ok(listaReservas);
    }

    @PutMapping("/cancelar/{id}")
    public ResponseEntity<ReservaDto> cancelarReserva(@PathVariable("id") Integer idReserva) {
        ReservaDto reservaDto = iReservaService.cancelarReserva(idReserva);
        return ResponseEntity.ok(reservaDto);
    }

    @GetMapping("/web/{id}")
    public ResponseEntity<Optional<Reserva>> listarPorId(@PathVariable("id") Integer reservaId) {
        Optional<Reserva> reserva = iReservaService.listarPorId(reservaId);
        return ResponseEntity.ok(reserva);
    }
    @PutMapping("/web/{id}")
    public ResponseEntity<ReservaDto> actualizar2(@PathVariable("id") Integer reservaId,
                                                 @RequestBody ReservaDto2 updatedReserva) {
        ReservaDto reservaDto = iReservaService.actualizar2(reservaId, updatedReserva);
        return ResponseEntity.ok(reservaDto);
    }
}
