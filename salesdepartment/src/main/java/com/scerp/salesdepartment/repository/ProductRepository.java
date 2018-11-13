package com.scerp.salesdepartment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scerp.salesdepartment.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
