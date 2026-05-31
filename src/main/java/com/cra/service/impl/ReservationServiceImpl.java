package com.cra.service.impl;

import java.util.List;

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
			customerRepository.save(customerEntity);
		
		//map vehiclerequest DTO to reservation entity and save
			VehicleRequestDTO vehicleRequestDTO =  reservationRequestDTO.getVehicleRequestDTO();
			
			ReservationEntity reservationEntity = new ReservationEntity();
			reservationEntity.setReservationId();
			reservationEntity.setCustomerId();
			reservationEntity.setVehicleType();
			reservationEntity.setStartDate();
			reservationEntity.setEndDate();
			reservationEntity.setEstimatedDailyMileage();
			reservationEntity.setTotalCost();
			reservationEntity.setStatus();
		
		//set data in reservationstatuscomm entity and save 
		
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
