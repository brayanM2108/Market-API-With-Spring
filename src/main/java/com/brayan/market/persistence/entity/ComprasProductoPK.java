package com.brayan.market.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
public class ComprasProductoPK implements Serializable {


    @Getter @Setter @Column(name = "id_compra")
    private Integer idCompra;

    @Getter @Setter @Column(name = "id_producto")
    private Integer idProducto;
}
