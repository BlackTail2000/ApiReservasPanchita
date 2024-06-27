package com.cibertec.apireservaspanchita.model.bd;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @ManyToOne
    @JoinColumn(name ="id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;
    @Temporal(TemporalType.DATE)
    private Date fechaReserva;
    @Enumerated(EnumType.STRING)
    private Estado estado;
}
