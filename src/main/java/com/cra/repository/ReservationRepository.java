package com.cra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cra.entity.ReservationEntity;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity,Long> {

	
	 @Query("SELECT r FROM ReservationEntity r WHERE r.reservationId = :resId")
	 Optional<ReservationEntity> findByStringIdCustom(@Param("resId") String resId);
}
