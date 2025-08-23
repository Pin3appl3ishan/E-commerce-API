package com.codewithmosh.store.products;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

@Configuration
public interface CategoryRepository extends CrudRepository<Category, Byte> {
}