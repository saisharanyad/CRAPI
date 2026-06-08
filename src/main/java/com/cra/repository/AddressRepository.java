package com.cra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cra.entity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Long> {

}
