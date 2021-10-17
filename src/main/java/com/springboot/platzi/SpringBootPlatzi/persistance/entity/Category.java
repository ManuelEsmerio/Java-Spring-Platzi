package com.springboot.platzi.SpringBootPlatzi.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
@Data
@AllArgsConstructor  @NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria", nullable = false)
    private Integer id;

    @Column(name = "descripcion", nullable = false)
    private String description;

    @Column(name = "estado", nullable = false)
    private Boolean status;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
