package com.cra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cra.entity.ReservationEntity;

public interface ReservationRepository extends JpaRepository<ReservationEntity,Long> {

}
