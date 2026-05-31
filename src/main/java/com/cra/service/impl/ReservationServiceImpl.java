package com.cra.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.cra.constants.ReservationStatus;
import com.cra.entity.ReservationStatusCommEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cra.dto.AddressDTO;
import com.cra.dto.CustomerDTO;
import com.cra.dto.ReservationRequestDTO;
import com.cra.dto.VehicleRequestDTO;
import com.cra.dto.VehicleResponseDTO;
import com.cra.entity.AddressEntity;
import com.cra.entity.CustomerEntity;
import com.cra.entity.ReservationEntity;
import com.cra.repository.AddressRepository;
import com.cra.repository.CustomerRepository;
import com.cra.repository.InventoryRepository;
import com.cra.repository.ReservationRepository;
import com.cra.repository.ReservationStatusRepository;
import com.cra.service.ReservationService;

public class ReservationServiceImpl implements ReservationService {
	
	private CustomerRepository customerRepository;
	private AddressRepository addressRepository;
	private InventoryRepository inventoryRepository;
	private ReservationRepository reservationRepository;
	private ReservationStatusRepository reservationStatusRepository;
	
	@Autowired
	public ReservationServiceImpl(AddressRepository addressRepository,
			CustomerRepository customerRepository,
			InventoryRepository inventoryRepository,
			ReservationRepository reservationRepository,
			ReservationStatusRepository reservationStatusRepository
			)
	{
		this.addressRepository = addressRepository;
		this.customerRepository = customerRepository;
		this.inventoryRepository = inventoryRepository;
		this.reservationRepository = reservationRepository;
		this.reservationStatusRepository = reservationStatusRepository;	
		
	}

	@Override
	@Transactional
	public void reserveCar(ReservationRequestDTO reservationRequestDTO) {
		
		//map address DTO to address entity[could use a mapper here]
			AddressDTO addressDTO = reservationRequestDTO.getAddressDTO();

			AddressEntity addrEntity = new AddressEntity();
			addrEntity.setStreetNo(addressDTO.getStreetNo());
			addrEntity.setCity(addressDTO.getCity());
			addrEntity.setState(addressDTO.getState());
			addrEntity.setCountry(addressDTO.getCountry());
			addrEntity.setZipcode(addressDTO.getZipcode());


		//map customer DTO to customer entity and set in address entity
			CustomerDTO customerDTO = reservationRequestDTO.getCustomerDTO();

			CustomerEntity customerEntity = new CustomerEntity();
			customerEntity.setFirstName(customerDTO.getFirstName());
			customerEntity.setLastName(customerDTO.getLastName());
			customerEntity.setEmailId(customerDTO.getEmailId());
			customerEntity.setPhoneNo(customerDTO.getPhoneNo());
			customerEntity.setAddress(addrEntity);

		//save address entity
			CustomerEntity savedCustomer = customerRepository.save(customerEntity);
		
		//insert vehicle request  to reservation entity and save

			ReservationEntity reservationEntity = new ReservationEntity();
			reservationEntity.setCustomerId(savedCustomer.getCustomerId().toString());
			reservationEntity.setVehicleType(reservationRequestDTO.getVehicleType());
			reservationEntity.setStartDate(Timestamp.valueOf(reservationRequestDTO.getStartDate()));
			reservationEntity.setEndDate(Timestamp.valueOf(reservationRequestDTO.getStartDate()));
			reservationEntity.setEstimatedDailyMileage(reservationRequestDTO.getPerDayMileage());
			reservationEntity.setTotalCost(reservationRequestDTO.getTotalCost());
			reservationEntity.setStatus(ReservationStatus.RESERVED.toString());

			ReservationEntity savedReservation = reservationRepository.save(reservationEntity);
		
		//set data in reservationstatuscomm entity and save
		ReservationStatusCommEntity reservationStatusCommEntity = new ReservationStatusCommEntity();
		reservationStatusCommEntity.setEventId(UUID.randomUUID());
		reservationStatusCommEntity.setReservationId(savedReservation.getReservationId());
		reservationStatusCommEntity.setReservationType(savedReservation.getStatus());
		reservationStatusCommEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		reservationStatusCommEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		reservationStatusCommEntity.setProcessed(false);
		reservationStatusCommEntity.setEventType("COMMUNICATION_AWAIT");
		reservationStatusRepository.save(reservationStatusCommEntity);

	}

	@Override
	public void modifyReservation(String reservationId, ReservationRequestDTO reservationRequestDTO) {
		
		
	}

	@Override
	public void cancelReservation(String reservationId) {
		
		
	}

	@Override
	public List<VehicleResponseDTO> getOptions(VehicleRequestDTO vehiclesRequestDTO) {
		
		return null;
	}

}
