package com.cibertec.apireservaspanchita.controller;

import com.cibertec.apireservaspanchita.model.dto.SucursalDto;
import com.cibertec.apireservaspanchita.service.ISucursalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {

    private ISucursalService iSucursalService;

    @PostMapping
    public ResponseEntity<SucursalDto> registrar(@RequestBody SucursalDto sucursalDto) {
        SucursalDto sucursalRegister = iSucursalService.registrar(sucursalDto);
        return new ResponseEntity<>(sucursalRegister, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SucursalDto>> listarlasTodas() {
        List<SucursalDto> sucursales = iSucursalService.listarlasTodas();
        return ResponseEntity.ok(sucursales);
    }

    @GetMapping("{id}")
    public ResponseEntity<SucursalDto> obtenerPorId(@PathVariable("id") Integer sucursalId) {
        SucursalDto sucursalDto = iSucursalService.buscarPorId(sucursalId);
        return ResponseEntity.ok(sucursalDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<SucursalDto> actualizar(@PathVariable("id") Integer sucursalId,
                                                  @RequestBody SucursalDto updatedSucursal) {
        SucursalDto sucursalDto = iSucursalService.actualizar(sucursalId, updatedSucursal);
        return ResponseEntity.ok(sucursalDto);
    }
}
