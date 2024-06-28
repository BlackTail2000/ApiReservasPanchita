package com.cibertec.apireservaspanchita.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Locale;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HorarioDto {
    private Integer idHorario;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = JsonFormat.DEFAULT_LOCALE)
    private Date horaInicio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = JsonFormat.DEFAULT_LOCALE)
    private Date horaFin;
    private Integer idSucursal;
}
