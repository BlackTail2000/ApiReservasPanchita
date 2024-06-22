package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.bd.Menu;
import com.cibertec.apireservaspanchita.model.bd.Sucursal;
import com.cibertec.apireservaspanchita.model.dto.MenuDto;
import com.cibertec.apireservaspanchita.model.exception.ResourceNotFoundException;
import com.cibertec.apireservaspanchita.model.mapper.MenuMapper;
import com.cibertec.apireservaspanchita.repository.MenuRepository;
import com.cibertec.apireservaspanchita.repository.SucursalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MenuService implements IMenuService {

    private MenuRepository menuRepository;
    private SucursalRepository sucursalRepository;

    @Override
    public MenuDto registrar(MenuDto menuDto) {
        Sucursal sucursal = sucursalRepository.findById(menuDto.getIdSucursal())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró la sucursal con el id: " + menuDto.getIdSucursal()));
        Menu menu = MenuMapper.mapToMenu(menuDto, sucursal);
        menuRepository.save(menu);
        return MenuMapper.mapToManuDto(menu);
    }

    @Override
    public MenuDto buscarPorId(Integer menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró el menú con el id: " + menuId));
        return MenuMapper.mapToManuDto(menu);
    }
}
