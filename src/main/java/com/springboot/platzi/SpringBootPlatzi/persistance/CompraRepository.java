package com.springboot.platzi.SpringBootPlatzi.persistance;

import com.springboot.platzi.SpringBootPlatzi.domain.Purchase;
import com.springboot.platzi.SpringBootPlatzi.domain.repository.PurchaseRepository;
import com.springboot.platzi.SpringBootPlatzi.persistance.crud.ComprasCrudRepository;
import com.springboot.platzi.SpringBootPlatzi.persistance.entity.Compra;
import com.springboot.platzi.SpringBootPlatzi.persistance.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private ComprasCrudRepository comprasCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) comprasCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByCustomer(String customerId) {
        return comprasCrudRepository.findByIdCliente(customerId)
                .map(item -> mapper.toPurchases(item));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(product -> product.setCompra(compra));
        return mapper.toPurchase(comprasCrudRepository.save(compra));
    }
}
