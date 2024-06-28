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
public class ReservaDto2 extends ReservaDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", locale = JsonFormat.DEFAULT_LOCALE)
    private Date horaInicio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", locale = JsonFormat.DEFAULT_LOCALE)
    private Date horaFin;
}
