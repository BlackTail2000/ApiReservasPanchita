package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.dto.UsuarioDto;

public interface IUsuarioService {
    UsuarioDto registrar(UsuarioDto usuarioDto);
    UsuarioDto buscarPorId(Integer idUsuario);
    UsuarioDto loginUsuario(String login, String password);
    UsuarioDto actualizarUsuario(Integer idUsuario, UsuarioDto usuarioDto);
    UsuarioDto buscarPorUsername(String username);
    UsuarioDto buscarPorEmail(String email);
}
