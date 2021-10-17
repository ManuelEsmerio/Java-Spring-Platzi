package com.springboot.platzi.SpringBootPlatzi.persistance.crud;

import com.springboot.platzi.SpringBootPlatzi.persistance.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?" , nativeQuery = true)
    List<Product> findByIdCategory(int idCategory);

    List<Product> findByIdCategoryOrderByNombreAsc(int idCategory);

    List<Product> findByIdCategoryOrderByNombreDesc(int idCategory);

    Optional<List<Product>> findByStockLessThanAndStatus(int stock, boolean status);

}
