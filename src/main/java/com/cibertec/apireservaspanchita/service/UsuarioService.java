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
        Usuario usuario = UsuarioMapper.mapToUsuario(usuarioDto);
        usuarioRepository.save(usuario);
        return UsuarioMapper.mapToUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto buscarPorId(Integer idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró el usuario con id: " + idUsuario));
        return UsuarioMapper.mapToUsuarioDto(usuario);
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
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró el usuario con id: " + idUsuario));

        usuario.setNombres(usuarioDto.getNombres());
        usuario.setApellidos(usuarioDto.getApellidos());
        usuario.setDni(usuarioDto.getDni());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setRol(usuarioDto.getRol());
        usuario.setFechaNac(usuarioDto.getFechaNac());
        usuario.setPassword(usuarioDto.getPassword());

        Usuario updatedUsuario = usuarioRepository.save(usuario);
        return UsuarioMapper.mapToUsuarioDto(updatedUsuario);
    }
}
