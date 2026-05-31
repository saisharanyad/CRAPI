package com.cra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cra.entity.ReservationStatusCommEntity;

public interface ReservationStatusRepository extends JpaRepository<ReservationStatusCommEntity,Long> {

}
