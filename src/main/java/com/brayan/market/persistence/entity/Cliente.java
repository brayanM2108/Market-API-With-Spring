package com.brayan.market.persistence.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String apellidos;

    @Getter @Setter
    private String celular;

    @Getter @Setter
    private String direccion;

    @Getter @Setter @Column(name ="correo_electronico")
    private String email;

    @OneToMany(mappedBy = "cliente")
    @Getter @Setter
    private List<Compra> compras;


}
