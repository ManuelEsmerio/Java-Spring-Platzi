package com.springboot.platzi.SpringBootPlatzi.domain.service;

import com.springboot.platzi.SpringBootPlatzi.domain.Product;
import com.springboot.platzi.SpringBootPlatzi.domain.repository.ProductRepository;
import com.springboot.platzi.SpringBootPlatzi.persistance.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int idCategory){
        return productRepository.getByCategory(idCategory);
    }

    public Optional<List<Product>> getScarseProducts(int quantity){
        return productRepository.getScarseProducts(quantity);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId){

        /*if (getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        }else{
            return false;
        }*/

        return getProduct(productId).map(item -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
