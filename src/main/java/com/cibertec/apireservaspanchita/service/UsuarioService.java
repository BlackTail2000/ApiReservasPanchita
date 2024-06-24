package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.bd.Usuario;
import com.cibertec.apireservaspanchita.model.dto.UsuarioDto;
import com.cibertec.apireservaspanchita.model.exception.ResourceNotFoundException;
import com.cibertec.apireservaspanchita.model.mapper.UsuarioMapper;
import com.cibertec.apireservaspanchita.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto registrar(UsuarioDto usuarioDto) {
        return null;
    }

    @Override
    public UsuarioDto buscarPorId(Integer idUsuario) {
        return null;
    }

    @Override
    public UsuarioDto loginUsuario(String login, String password) {
        Usuario usuario = usuarioRepository.loginUsuario(login, password)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuario y/o contraseña incorrectos"));
        return UsuarioMapper.mapToUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto actualizarUsuario(Integer idUsuario, UsuarioDto usuarioDto) {
        return null;
    }
}
