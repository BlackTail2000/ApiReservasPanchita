package com.cibertec.apireservaspanchita.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlato;
    private String nombrePlato;
    @ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu menu;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}
