package com.cibertec.apireservaspanchita.controller;

import com.cibertec.apireservaspanchita.model.dto.HorarioDto;
import com.cibertec.apireservaspanchita.service.IHorarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horario")
@AllArgsConstructor
public class HorarioController {

    private IHorarioService iHorarioService;

    @PostMapping
    public ResponseEntity<HorarioDto> registrar(@RequestBody HorarioDto horarioDto) {
        HorarioDto horarioRegister = iHorarioService.registrar(horarioDto);
        return new ResponseEntity<>(horarioRegister, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<HorarioDto> obtenerPorId(@PathVariable("id") Integer horarioId) {
        HorarioDto horarioDto = iHorarioService.buscarPorId(horarioId);
        return ResponseEntity.ok(horarioDto);
    }

    @GetMapping("/sucursal/{id}")
    public ResponseEntity<List<HorarioDto>> obtenerPorSucursalId(@PathVariable("id") Integer sucursalId) {
        List<HorarioDto> horarioDto = iHorarioService.listarPorSucursal(sucursalId);
        return ResponseEntity.ok(horarioDto);
    }
}
