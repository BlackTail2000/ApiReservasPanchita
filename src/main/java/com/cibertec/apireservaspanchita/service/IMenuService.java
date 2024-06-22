package com.cibertec.apireservaspanchita.service;

import com.cibertec.apireservaspanchita.model.dto.MenuDto;

public interface IMenuService {
    MenuDto registrar(MenuDto menuDto);
    MenuDto buscarPorId(Integer menuId);
}
