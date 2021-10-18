package com.springboot.platzi.SpringBootPlatzi.persistance.crud;

import com.springboot.platzi.SpringBootPlatzi.persistance.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ComprasCrudRepository extends CrudRepository<Compra, Integer> {

    Optional<List<Compra>> findByIdCliente(String idCliente);
}
