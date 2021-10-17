package com.springboot.platzi.SpringBootPlatzi.persistance.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
@Data
public class PurchaseProduct {

    @EmbeddedId
    private PurchaseProductPK id;

    @Column(name = "cantidad")
    private Integer stock;

    @Column(name = "total")
    private Double amount;

    @Column(name = "estado")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;
}
