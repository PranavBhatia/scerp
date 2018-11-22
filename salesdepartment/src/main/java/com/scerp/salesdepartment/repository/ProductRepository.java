package com.scerp.salesdepartment.repository;

import org.springframework.transaction.annotation.Transactional;import javax.persistence.Entity;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.scerp.salesdepartment.domain.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
	@Modifying
	@Transactional
	void deleteByproductId(String productId);
	
	/*@Modifying(clearAutomatically = true)
	@Transactional(readOnly = false)
	@Query("UPDATE product p SET p.quantity = ?1 WHERE p.productId = ?2")
	int setNewQuantityForProduct(String quantity, String productId);*/
	
	
}
