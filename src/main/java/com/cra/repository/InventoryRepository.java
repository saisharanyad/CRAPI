package com.cra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cra.entity.InventoryEntity;

public interface InventoryRepository extends JpaRepository<InventoryEntity,Long> {

}
