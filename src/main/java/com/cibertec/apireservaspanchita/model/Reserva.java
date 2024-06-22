package com.cibertec.apireservaspanchita.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroOrden;
    private Integer cantidadComensales;
    @ManyToOne
    @JoinColumn(name = "id_horario")
    private Horario horario;
    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;
    @Temporal(TemporalType.DATE)
    private Date fechaReserva;
    @Enumerated(EnumType.STRING)
    private Estado estado;
}
