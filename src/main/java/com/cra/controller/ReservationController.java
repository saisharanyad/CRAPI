package com.cra.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cra.dto.ReservationRequestDTO;
import com.cra.dto.ResponseDTO;
import com.cra.dto.VehicleRequestDTO;
import com.cra.dto.VehicleResponseDTO;
import com.cra.service.ReservationService;
import com.cra.constants.ReservationConstants;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/reservation/v1")
public class ReservationController {
	
	private static final Logger log = LoggerFactory.getLogger(ReservationController.class);
	
	private ReservationService reservationService;
	
	@Autowired
	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@PostMapping("/vehicles/reserve")
	public ResponseEntity<ResponseDTO> 
		addReservation(@Valid @RequestBody ReservationRequestDTO reservationRequestDto) {

		reservationService.reserveCar(reservationRequestDto);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDTO(ReservationConstants.STATUS_201, ReservationConstants.MESSAGE_201));
	}

	@PutMapping
	public ResponseEntity<ResponseDTO> updateReservation(@RequestParam Long reservationId,
			@RequestBody ReservationRequestDTO reservationRequestDTO) {

		boolean isUpdated = false;
		
		isUpdated = reservationService.modifyReservation(reservationId,reservationRequestDTO);
		
		if (isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO(ReservationConstants.STATUS_200, ReservationConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseDTO(ReservationConstants.STATUS_500, ReservationConstants.MESSAGE_500_UPDATE));
		}
	}

	@DeleteMapping
	public ResponseEntity<ResponseDTO> cancelReservation(@RequestParam String reservationId) {
		
		log.info("in cancelReservation with reservationId::: "+reservationId);
		boolean isDeleted = false;
		 isDeleted = reservationService.cancelReservation(reservationId);
		if (isDeleted) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO(ReservationConstants.STATUS_200, ReservationConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseDTO(ReservationConstants.STATUS_500, ReservationConstants.MESSAGE_500_DELETE));
		}
	}

	@PostMapping("/vehicles/search")
	public ResponseEntity<List<VehicleResponseDTO>> getVehicleOptions(
			 @RequestBody VehicleRequestDTO vehiclesRequestDTO) {

		log.info("in getVehicleOptions with parameters ::: "
				+ vehiclesRequestDTO.getStartDate()+" "
				+ vehiclesRequestDTO.getEndDate()+" "
				+ vehiclesRequestDTO.getLicenseNo()+" "
				+ vehiclesRequestDTO.getPerDayMileage()+" "
				+ vehiclesRequestDTO.getDateOfBirth()
				
		);
		return ResponseEntity.status(HttpStatus.OK).body(
				reservationService.getOptions(vehiclesRequestDTO)
		);

	}
	
	@GetMapping("/hello")
	public String test(){
		return "hello";
	}
}
