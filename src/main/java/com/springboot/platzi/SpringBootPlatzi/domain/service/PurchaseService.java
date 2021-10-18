package com.springboot.platzi.SpringBootPlatzi.domain.service;

import com.springboot.platzi.SpringBootPlatzi.domain.Purchase;
import com.springboot.platzi.SpringBootPlatzi.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByCustomer(String customerId){
        return purchaseRepository.getByCustomer(customerId);
    }

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
}
