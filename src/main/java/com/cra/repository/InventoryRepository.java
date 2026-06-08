package com.cra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cra.entity.InventoryEntity;

import jakarta.persistence.LockModeType;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity,Long> {
	
	
	 @Lock(LockModeType.PESSIMISTIC_WRITE) // Appends "FOR UPDATE" to the SQL query
	 @Query("SELECT i FROM InventoryEntity i WHERE i.vehicleType = :vehicleType")
	 Optional<InventoryEntity> findByVehicleType(@Param("vehicleType") String vehicleType);


}
