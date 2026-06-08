package com.cra.service;

import java.util.List;

import com.cra.dto.ReservationRequestDTO;
import com.cra.dto.VehicleRequestDTO;
import com.cra.dto.VehicleResponseDTO;

public interface ReservationService {
	
	    void reserveCar(ReservationRequestDTO reservationRequestDTO);
	    boolean modifyReservation(Long reservationId,
	    		ReservationRequestDTO reservationRequestDTO);
	    boolean cancelReservation(String reservationId);
	    List<VehicleResponseDTO> getOptions(VehicleRequestDTO vehiclesRequestDTO);
}
