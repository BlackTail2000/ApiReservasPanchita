package com.cibertec.apireservaspanchita.controller;

import com.cibertec.apireservaspanchita.model.dto.MenuDto;
import com.cibertec.apireservaspanchita.service.IMenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menu")
@AllArgsConstructor
public class MenuController {

    private IMenuService iMenuService;

    @PostMapping
    public ResponseEntity<MenuDto> registrar(@RequestBody MenuDto menuDto) {
        MenuDto menuRegister = iMenuService.registrar(menuDto);
        return new ResponseEntity<>(menuRegister, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MenuDto> obtenerPorId(@PathVariable("id") Integer menuId) {
        MenuDto menuDto = iMenuService.buscarPorId(menuId);
        return ResponseEntity.ok(menuDto);
    }
}
