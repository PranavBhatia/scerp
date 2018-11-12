package com.scerp.administrationdepartment.repository;

import org.springframework.data.repository.CrudRepository;

import com.scerp.administrationdepartment.domain.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}

