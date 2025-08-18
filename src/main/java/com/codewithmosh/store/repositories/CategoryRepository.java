package com.codewithmosh.store.repositories;

import com.codewithmosh.store.entities.Category;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

@Configuration
public interface CategoryRepository extends CrudRepository<Category, Byte> {
}