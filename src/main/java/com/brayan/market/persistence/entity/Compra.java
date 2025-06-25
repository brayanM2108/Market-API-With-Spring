package com.brayan.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_compra")
    private Integer idCompra;

    @Getter @Setter @Column(name = "id_cliente")
    private String idCliente;

    @Getter @Setter
    private LocalDateTime fecha;

    @Getter @Setter @Column(name = "medio_pago")
    private String medioPago;

    @Getter @Setter
    private String comentario;

    @Getter @Setter
    private String estado;


    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    @Getter @Setter
    private Cliente cliente;

    @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL})
    @Getter @Setter
    private List<ComprasProducto> productos;

}
