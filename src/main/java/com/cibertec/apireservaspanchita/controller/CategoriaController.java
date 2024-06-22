package com.cibertec.apireservaspanchita.controller;

import com.cibertec.apireservaspanchita.model.dto.CategoriaDto;
import com.cibertec.apireservaspanchita.service.ICategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
@AllArgsConstructor
public class CategoriaController {

    private ICategoriaService iCategoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDto> registrar(@RequestBody CategoriaDto categoriaDto) {
        CategoriaDto categoriaRegister = iCategoriaService.registrar(categoriaDto);
        return new ResponseEntity<>(categoriaRegister, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> listarlasTodas() {
        List<CategoriaDto> listaCategorias = iCategoriaService.listarlasTodas();
        return ResponseEntity.ok(listaCategorias);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoriaDto> obtenerPorId(@PathVariable("id") Integer categoriaId) {
        CategoriaDto categoriaDto = iCategoriaService.buscarPorId(categoriaId);
        return ResponseEntity.ok(categoriaDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoriaDto> actualizar(@PathVariable("id") Integer categoriaId,
                                                   @RequestBody CategoriaDto updatedCategoria) {
        CategoriaDto categoriaDto = iCategoriaService.actualizar(categoriaId, updatedCategoria);
        return ResponseEntity.ok(categoriaDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer categoriaId) {
        iCategoriaService.eliminar(categoriaId);
        return ResponseEntity.ok("Categoría eliminada");
    }
}
