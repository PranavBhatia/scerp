package com.scerp.salesdepartment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.scerp.salesdepartment.domain.OrderEntity;


	
@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long>{


}