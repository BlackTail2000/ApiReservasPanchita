package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.bd.Categoria;
import com.cibertec.apireservaspanchita.model.bd.Menu;
import com.cibertec.apireservaspanchita.model.bd.Plato;
import com.cibertec.apireservaspanchita.model.dto.PlatoDto;
import com.cibertec.apireservaspanchita.model.exception.ResourceNotFoundException;
import com.cibertec.apireservaspanchita.model.mapper.PlatoMapper;
import com.cibertec.apireservaspanchita.repository.CategoriaRepository;
import com.cibertec.apireservaspanchita.repository.MenuRepository;
import com.cibertec.apireservaspanchita.repository.PlatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlatoService implements IPlatoService {

    private PlatoRepository platoRepository;
    private CategoriaRepository categoriaRepository;
    private MenuRepository menuRepository;

    @Override
    public PlatoDto registrar(PlatoDto platoDto) {
        Categoria categoria = categoriaRepository.findById(platoDto.getIdCategoria())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la categoría con el id: " + platoDto.getIdCategoria()));
        Menu menu = menuRepository.findById(platoDto.getIdMenu())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró el menú con el id: " + platoDto.getIdMenu()));
        Plato plato = PlatoMapper.mapToPlato(platoDto, menu, categoria);
        platoRepository.save(plato);
        return PlatoMapper.mapToPlatoDto(plato);
    }

    @Override
    public List<PlatoDto> listarlosTodos() {
        List<Plato> listaPlato = platoRepository.findAll();
        return listaPlato.stream().map(PlatoMapper::mapToPlatoDto)
                .collect(Collectors.toList());
    }

    @Override
    public PlatoDto buscarPorId(Integer platoId) {
        Plato plato = platoRepository.findById(platoId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró el plato con el id: " + platoId));
        return PlatoMapper.mapToPlatoDto(plato);
    }

    @Override
    public PlatoDto actualizar(Integer platoId, PlatoDto platoDto) {
        Plato plato = platoRepository.findById(platoId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró el plato con el id: " + platoId));
        Categoria categoria = categoriaRepository.findById(platoDto.getIdCategoria())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la categoría con el id: " + platoDto.getIdCategoria()));
        Menu menu = menuRepository.findById(platoDto.getIdMenu())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró el menú con el id: " + platoDto.getIdMenu()));
        plato.setNombrePlato(platoDto.getNombrePlato());
        plato.setMenu(menu);
        plato.setCategoria(categoria);

        Plato updatedPlato = platoRepository.save(plato);
        return PlatoMapper.mapToPlatoDto(updatedPlato);
    }
}
