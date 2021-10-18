package com.springboot.platzi.SpringBootPlatzi.web.controller;

import com.springboot.platzi.SpringBootPlatzi.domain.Purchase;
import com.springboot.platzi.SpringBootPlatzi.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK) ;
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<Purchase>> findByCustomer(@PathVariable("id") String customerId){
        return purchaseService.getByCustomer(customerId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
