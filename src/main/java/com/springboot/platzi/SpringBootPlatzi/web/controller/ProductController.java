package com.springboot.platzi.SpringBootPlatzi.web.controller;

import com.springboot.platzi.SpringBootPlatzi.domain.Product;
import com.springboot.platzi.SpringBootPlatzi.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Product>> getAll(){
        // Recibe 2 parametros el ReponseEntity
        // 1.- El cuerpo de la respuesta
        // 2. El Estatus HTTP
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    @ApiOperation("Search products by idCategory")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    public ResponseEntity<List<Product>> getByCategory(@ApiParam(value = "The unique key of the category of the products you need to search", required = true, example = "7")
                                                           @PathVariable("id") int categoryId){
        return productService.getByCategory(categoryId)
                .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    @ApiOperation("Search product by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No Records")
    })
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The unique key of the product you need to search", required = true, example = "1")
                                                  @PathVariable("id") int productId){

        //return ResponseEntity.of(productService.getProduct(productId));
        return productService.getProduct(productId)
                .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    //@ResponseBody
    public ResponseEntity delete(@PathVariable("id") int productId){
        if (productService.delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
