package com.cibertec.apireservaspanchita.controller;

import com.cibertec.apireservaspanchita.model.bd.Plato;
import com.cibertec.apireservaspanchita.model.dto.PlatoDto;
import com.cibertec.apireservaspanchita.service.IPlatoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plato")
@AllArgsConstructor
public class PlatoController {

    private IPlatoService iPlatoService;

    @PostMapping
    public ResponseEntity<PlatoDto> registrar(@RequestBody PlatoDto platoDto) {
        PlatoDto platoRegister = iPlatoService.registrar(platoDto);
        return new ResponseEntity<>(platoRegister, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlatoDto>> listarlosTodos() {
        List<PlatoDto> listaPlatos = iPlatoService.listarlosTodos();
        return ResponseEntity.ok(listaPlatos);
    }

    @GetMapping("{id}")
    public ResponseEntity<PlatoDto> obtenerPorId(@PathVariable("id") Integer platoId) {
        PlatoDto platoDto = iPlatoService.buscarPorId(platoId);
        return ResponseEntity.ok(platoDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<PlatoDto> actualizar(@PathVariable("id") Integer platoId,
                                               @RequestBody PlatoDto updatedPlato) {
        PlatoDto platoDto = iPlatoService.actualizar(platoId, updatedPlato);
        return ResponseEntity.ok(platoDto);
    }
}
