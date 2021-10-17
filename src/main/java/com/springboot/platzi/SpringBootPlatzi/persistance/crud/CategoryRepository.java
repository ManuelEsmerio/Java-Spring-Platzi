package com.springboot.platzi.SpringBootPlatzi.persistance.crud;

import com.springboot.platzi.SpringBootPlatzi.persistance.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
