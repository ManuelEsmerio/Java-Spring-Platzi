package com.springboot.platzi.SpringBootPlatzi.persistance.crud;

import com.springboot.platzi.SpringBootPlatzi.persistance.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
}
