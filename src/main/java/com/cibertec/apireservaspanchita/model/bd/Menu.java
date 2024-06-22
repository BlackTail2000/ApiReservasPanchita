package com.cibertec.apireservaspanchita.model.bd;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMenu;
    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;
}
