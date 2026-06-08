package com.cra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cra.entity.ReservationStatusCommEntity;

@Repository
public interface ReservationStatusRepository extends JpaRepository<ReservationStatusCommEntity,Long> {

}
