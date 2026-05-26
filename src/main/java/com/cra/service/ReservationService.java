package com.cra.service;

import java.util.List;

import com.cra.dto.ReservationRequestDTO;
import com.cra.dto.VehiclesRequestDTO;
import com.cra.dto.VehiclesResponseDTO;

public interface ReservationService {
	
	    void reserveCar(ReservationRequestDTO reservationRequestDTO);
	    void modifyReservation(String reservationId, 
	    		ReservationRequestDTO reservationRequestDTO);
	    void cancelReservation(String reservationId);
	    List<VehiclesResponseDTO> getOptions(VehiclesRequestDTO vehiclesRequestDTO);
}
