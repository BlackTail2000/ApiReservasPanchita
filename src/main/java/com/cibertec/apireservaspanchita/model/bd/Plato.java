package com.cibertec.apireservaspanchita.model.bd;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlato;
    private String nombrePlato;
    private String foto;
    @ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu menu;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}
