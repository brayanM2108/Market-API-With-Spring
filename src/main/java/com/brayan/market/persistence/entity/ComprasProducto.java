package com.brayan.market.persistence.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="compras_productos")
public class ComprasProducto {

    @EmbeddedId
    @Getter @Setter
    private ComprasProductoPK id;

    @Getter @Setter
    private Integer cantidad;

    @Getter @Setter
    private Double total;

    @Getter @Setter
    private Boolean estado;

    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    @Getter @Setter
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    @Getter @Setter
    private Producto producto;
}
