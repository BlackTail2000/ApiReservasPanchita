package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.bd.Categoria;
import com.cibertec.apireservaspanchita.model.dto.CategoriaDto;
import com.cibertec.apireservaspanchita.model.exception.ResourceNotFoundException;
import com.cibertec.apireservaspanchita.model.mapper.CategoriaMapper;
import com.cibertec.apireservaspanchita.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriaService implements ICategoriaService {

    private CategoriaRepository categoriaRepository;

    @Override
    public CategoriaDto registrar(CategoriaDto categoriaDto) {
        Categoria categoria = CategoriaMapper.mapToCategoria(categoriaDto);
        categoriaRepository.save(categoria);
        return CategoriaMapper.mapToCategoriaDto(categoria);
    }

    @Override
    public List<CategoriaDto> listarlasTodas() {
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        return listaCategorias.stream().map(CategoriaMapper::mapToCategoriaDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDto buscarPorId(Integer categoriaId) {
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la categoría con el id: " + categoriaId));
        return CategoriaMapper.mapToCategoriaDto(categoria);
    }

    @Override
    public CategoriaDto actualizar(Integer categoriaId, CategoriaDto categoriaDto) {
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la categoría con el id: " + categoriaId));

        categoria.setNombreCategoria(categoriaDto.getNombreCategoria());

        Categoria updatedCategoria = categoriaRepository.save(categoria);
        return CategoriaMapper.mapToCategoriaDto(updatedCategoria);
    }

    @Override
    public void eliminar(Integer categoriaId) {
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la categoría con el id: " + categoriaId));

        categoriaRepository.deleteById(categoriaId);
    }
}
