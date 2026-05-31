package com.cra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cra.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity,Long> {

}
