package com.cra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cra.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
	
}
