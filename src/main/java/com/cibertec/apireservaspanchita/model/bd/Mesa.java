package com.cibertec.apireservaspanchita.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMesa;
    private Integer cantSillas;
    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;
}
