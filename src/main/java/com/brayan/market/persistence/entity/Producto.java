package com.brayan.market.persistence.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_producto")
    private Integer idProducto;

    @Getter @Setter
    private String nombre;

    @Getter @Setter @Column(name = "id_categoria")
    private Integer idCategoria;

    @Getter @Setter @Column(name = "codigo_barras")
    private String codigoBarras;

    @Getter @Setter @Column(name = "precio_venta")
    private Double precioVenta;

    @Getter @Setter @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    @Getter @Setter
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    @Getter @Setter
    private Categoria categoria;

}
