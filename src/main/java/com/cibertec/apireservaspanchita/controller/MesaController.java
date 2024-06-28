package com.cibertec.apireservaspanchita.controller;

import com.cibertec.apireservaspanchita.model.dto.MesaDto;
import com.cibertec.apireservaspanchita.service.IMesaService;
import com.cibertec.apireservaspanchita.utils.DateUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("/api/mesa")
public class MesaController {

    private IMesaService iMesaService;

    @PostMapping
    public ResponseEntity<MesaDto> registrar(@RequestBody MesaDto mesaDto) {
        MesaDto mesaRegistro = iMesaService.registrar(mesaDto);
        return new ResponseEntity<>(mesaRegistro, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MesaDto> obtenerPorId(@PathVariable("id") Integer idMesa) {
        MesaDto mesaDto = iMesaService.buscarPorId(idMesa);
        return ResponseEntity.ok(mesaDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<MesaDto> actualizar(@PathVariable("id") Integer idMesa,
                                                  @RequestBody MesaDto updatedMesa) {
        MesaDto mesaDto = iMesaService.actualizarMesa(idMesa, updatedMesa);
        return ResponseEntity.ok(mesaDto);
    }

    @GetMapping("/disponible/{fec}/{idS}")
    public ResponseEntity<Integer> obtenerNroMesasDisponiblesPorFechaYSucursal(@PathVariable("fec") String fecS,
                                                                               @PathVariable("idS") Integer idS) {
        Date fec = DateUtils.convertStringToDate(fecS);
        Integer nroMesasDisponibles = iMesaService.obtenerNroMesasDisponiblesPorFechaYSucursal(fec, idS);
        return ResponseEntity.ok(nroMesasDisponibles);
    }
}
