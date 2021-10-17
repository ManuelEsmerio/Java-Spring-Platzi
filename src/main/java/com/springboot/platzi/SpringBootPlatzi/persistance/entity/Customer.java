package com.springboot.platzi.SpringBootPlatzi.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor  @NoArgsConstructor
public class Customer {

    @EmbeddedId
    @Column(nullable = false)
    private String id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellidos")
    private String lastname;

    @Column(name = "celular")
    private Integer phoneNumber;

    @Column(name = "direccion")
    private String address;

    @Column(name = "correo_electronico")
    private String email;

    @OneToMany(mappedBy = "customer")
    List<Purchase> purchases;
}
