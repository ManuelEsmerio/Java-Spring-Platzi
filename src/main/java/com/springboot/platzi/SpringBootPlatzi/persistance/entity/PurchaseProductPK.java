package com.springboot.platzi.SpringBootPlatzi.persistance.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class PurchaseProductPK implements Serializable {

    @Column(name = "id_compra", nullable = false)
    private Integer idPruchase;

    @Column(name = "id_producto", nullable = false)
    private Integer idProduct;
}
