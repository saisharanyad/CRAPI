package com.cra.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.cra.dto.ErrorResponseDTO;
import com.cra.dto.ReservationRequestDTO;
import com.cra.dto.ResponseDTO;
import com.cra.dto.VehicleRequestDTO;
import com.cra.dto.VehicleResponseDTO;
import com.cra.service.ReservationService;
import com.cra.constants.ReservationConstants;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/reservation")
public class ReservationController {
	
	private static final Logger log = LoggerFactory.getLogger(ReservationController.class);
	
	private ReservationService reservationService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> 
		addReservation(@Valid @RequestBody ReservationRequestDTO reservationRequestDto) {

		reservationService.reserveCar(reservationRequestDto);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDTO(ReservationConstants.STATUS_201, ReservationConstants.MESSAGE_201));
	}

	@PutMapping
	public ResponseEntity<ResponseDTO> updateReservation(@RequestParam long bookId,
			@RequestParam String availabilityStatus) {

		boolean isUpdated = false;
		// isUpdated =
		// iBooksService.updateBookAvailabilityStatus(bookId,availabilityStatus);
		if (isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO(ReservationConstants.STATUS_200, ReservationConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseDTO(ReservationConstants.STATUS_500, ReservationConstants.MESSAGE_500_UPDATE));
		}
	}

	@DeleteMapping
	public ResponseEntity<ResponseDTO> cancelReservation(@RequestParam long bookId) {
		boolean isDeleted = false;
		// isDeleted = iBooksService.deleteBook(bookId);
		if (isDeleted) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO(ReservationConstants.STATUS_200, ReservationConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseDTO(ReservationConstants.STATUS_500, ReservationConstants.MESSAGE_500_DELETE));
		}
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehicleResponseDTO> getVehicleOptions(
			@Valid @RequestBody VehicleRequestDTO vehiclesRequestDTO) {

		return ResponseEntity.status(HttpStatus.OK).body(
				// iBooksService.searchBooks()
		);

	}

}
