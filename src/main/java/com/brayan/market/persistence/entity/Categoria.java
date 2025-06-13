package com.brayan.market.persistence.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer idCategoria;

    @Getter @Setter
    private String descripcion;

    @Getter @Setter
    private Boolean estado;

    @OneToMany(mappedBy = "categoria")
    @Getter @Setter
    private List<Producto> productos;

}
