package com.scerp.salesdepartment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.scerp.salesdepartment.domain.SalesQueryEntity;


	
@Repository
public interface SalesQueryRepository extends CrudRepository<SalesQueryEntity, Long>{


}