package com.cibertec.apireservaspanchita.model.mapper;

import com.cibertec.apireservaspanchita.model.bd.Usuario;
import com.cibertec.apireservaspanchita.model.dto.UsuarioDto;

public class UsuarioMapper {
    public static UsuarioDto mapToUsuarioDto(Usuario usuario) {
        return new UsuarioDto(
                usuario.getIdUsuario(),
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getDni(),
                usuario.getFechaNac(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getRol()
        );
    }

    public static Usuario mapToUsuario(UsuarioDto usuarioDto) {
        return new Usuario(
                usuarioDto.getIdUsuario(),
                usuarioDto.getNombres(),
                usuarioDto.getApellidos(),
                usuarioDto.getDni(),
                usuarioDto.getFechaNac(),
                usuarioDto.getEmail(),
                usuarioDto.getUsername(),
                usuarioDto.getPassword(),
                usuarioDto.getRol()
        );
    }
}
