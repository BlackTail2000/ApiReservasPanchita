package com.cibertec.apireservaspanchita.controller;

import com.cibertec.apireservaspanchita.model.bd.Estado;
import com.cibertec.apireservaspanchita.model.dto.ReservaDto;
import com.cibertec.apireservaspanchita.model.dto.ReservaDto2;
import com.cibertec.apireservaspanchita.service.IReservaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("{idUsuario}/{estado}")
    public ResponseEntity<List<ReservaDto2>> buscarPorIdUsuarioYEstado(@PathVariable("idUsuario") Integer idUsuario,
                                                                       @PathVariable("estado") Estado estado) {
        List<ReservaDto2> reservas = iReservaService.listarPorIdUsuarioYEstado(idUsuario, estado);
        return ResponseEntity.ok(reservas);
    }

    @PutMapping("/cancelar/{idReserva}")
    public ResponseEntity<ReservaDto> cancelarReserva(@PathVariable("idReserva") Integer idReserva) {
        ReservaDto updatedReserva = iReservaService.cancelarReserva(idReserva);
        return ResponseEntity.ok(updatedReserva);

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
