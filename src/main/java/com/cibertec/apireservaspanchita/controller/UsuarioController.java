package com.cibertec.apireservaspanchita.controller;

import com.cibertec.apireservaspanchita.model.dto.UsuarioDto;
import com.cibertec.apireservaspanchita.service.IUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/usuario")
public class UsuarioController {

    private IUsuarioService iUsuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> login(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioLogin = iUsuarioService.loginUsuario(usuarioDto.getUsername(), usuarioDto.getPassword());
        return ResponseEntity.ok(usuarioLogin);
    }
}
