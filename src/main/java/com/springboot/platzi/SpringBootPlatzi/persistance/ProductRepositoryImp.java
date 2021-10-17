package com.springboot.platzi.SpringBootPlatzi.persistance;

import com.springboot.platzi.SpringBootPlatzi.persistance.crud.ProductRepository;
import com.springboot.platzi.SpringBootPlatzi.persistance.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
// @Component
public class ProductRepositoryImp {
    private ProductRepository productRepository;

    public List<Product> getAll(){
        // Es necesario castear el resultado de findAll ya que manda un Iterable
        return (List<Product>) productRepository.findAll();
    }

    public List<Product> getByCategory(int idCategory){
        return  productRepository.findByIdCategory(idCategory);
    }

    public List<Product> getByCategoryAsc(int idCategory){
        return productRepository.findByIdCategoryOrderByNombreAsc(idCategory);
    }

    public List<Product> getByCategoryDesc(int idCategory){
        return productRepository.findByIdCategoryOrderByNombreDesc(idCategory);
    }

    public Optional<List<Product>> getWithOutStock(int stock){
        return productRepository.findByStockLessThanAndStatus(stock, true);
    }

    public Optional<Product> getProduct(int idProduct){
        return productRepository.findById(idProduct);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void delete(int idProduct){
        productRepository.deleteById(idProduct);
    }

    public void deleteByProduct(Product product){
        productRepository.delete(product);
    }
}
