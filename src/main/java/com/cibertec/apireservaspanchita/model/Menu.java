package com.cibertec.apireservaspanchita.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMenu;
    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;
}
