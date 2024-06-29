package com.cibertec.apireservaspanchita.model.dto;

import com.cibertec.apireservaspanchita.model.bd.Estado;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDto3 {
    private Integer numeroOrden;
    private Integer cantidadComensales;
    private HorarioDto horario;
    private SucursalDto sucursal;
    private UsuarioDto usuario;
    private MesaDto mesa;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaReserva;
    @Enumerated(EnumType.STRING)
    private Estado estado;
}
