package com.cibertec.apireservaspanchita.controller;

import com.cibertec.apireservaspanchita.model.dto.ReservaDto;
import com.cibertec.apireservaspanchita.model.dto.ReservaDto2;
import com.cibertec.apireservaspanchita.service.IReservaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
