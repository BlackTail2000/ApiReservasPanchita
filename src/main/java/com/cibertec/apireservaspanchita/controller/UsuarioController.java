package com.cibertec.apireservaspanchita.controller;

import com.cibertec.apireservaspanchita.model.dto.UsuarioDto;
import com.cibertec.apireservaspanchita.service.IUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/usuario")
public class UsuarioController {

    private IUsuarioService iUsuarioService;

    @PostMapping("/login")
    public ResponseEntity<UsuarioDto> login(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioLogin = iUsuarioService.loginUsuario(usuarioDto.getUsername(), usuarioDto.getPassword());
        return ResponseEntity.ok(usuarioLogin);
    }

    @PostMapping("/registro")
    public ResponseEntity<UsuarioDto> registro(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioRegistro = iUsuarioService.registrar(usuarioDto);
        return new ResponseEntity<>(usuarioRegistro, HttpStatus.CREATED);
    }

    @PostMapping("/username")
    public ResponseEntity<UsuarioDto> buscarPorUsername(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioUsername = iUsuarioService.buscarPorUsername(usuarioDto.getUsername());
        usuarioUsername.setPassword(null);
        return ResponseEntity.ok(usuarioUsername);
    }

    @PostMapping("/email")
    public ResponseEntity<UsuarioDto> buscarPorEmail(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioEmail = iUsuarioService.buscarPorEmail(usuarioDto.getEmail());
        usuarioEmail.setPassword(null);
        return ResponseEntity.ok(usuarioEmail);
    }
}
