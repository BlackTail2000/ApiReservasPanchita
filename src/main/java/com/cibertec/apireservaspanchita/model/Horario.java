package com.cibertec.apireservaspanchita.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHorario;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;
}
