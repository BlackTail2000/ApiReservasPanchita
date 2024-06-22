package com.cibertec.apireservaspanchita.model.mapper;

import com.cibertec.apireservaspanchita.model.bd.Menu;
import com.cibertec.apireservaspanchita.model.bd.Sucursal;
import com.cibertec.apireservaspanchita.model.dto.MenuDto;
import com.cibertec.apireservaspanchita.model.dto.SucursalDto;

public class MenuMapper {
    public static MenuDto mapToManuDto(Menu menu) {
        return new MenuDto(
                menu.getIdMenu(),
                menu.getSucursal().getIdSucursal()
        );
    }

    public static Menu mapToMenu(MenuDto menuDto, Sucursal sucursal) {
        return new Menu(
                menuDto.getIdMenu(),
                sucursal
        );
    }
}
