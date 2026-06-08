package com.cra.service.impl;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.cra.constants.ReservationStatus;
import com.cra.constants.VehicleCategory;
import com.cra.controller.ReservationController;
import com.cra.entity.ReservationStatusCommEntity;
import com.cra.exception.ResourceNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cra.dto.AddressDTO;
import com.cra.dto.CustomerDTO;
import com.cra.dto.InventoryDTO;
import com.cra.dto.ReservationRequestDTO;
import com.cra.dto.VehicleRequestDTO;
import com.cra.dto.VehicleResponseDTO;
import com.cra.entity.AddressEntity;
import com.cra.entity.CustomerEntity;
import com.cra.entity.InventoryEntity;
import com.cra.entity.ReservationEntity;
import com.cra.repository.AddressRepository;
import com.cra.repository.CustomerRepository;
import com.cra.repository.InventoryRepository;
import com.cra.repository.ReservationRepository;
import com.cra.repository.ReservationStatusRepository;
import com.cra.service.PricingStrategy;
import com.cra.service.ReservationService;


@Service
public class ReservationServiceImpl implements ReservationService {
	
	private static final Logger log = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	private CustomerRepository customerRepository;
	private AddressRepository addressRepository;
	private InventoryRepository inventoryRepository;
	private ReservationRepository reservationRepository;
	private ReservationStatusRepository reservationStatusRepository;
	private PricingStrategy pricingStrategy;
	private final Map<VehicleCategory, PricingStrategy> pricingRegistry = new HashMap<>();
	
	
	
	private void registerStrategy(PricingStrategy strategy) {
		log.info("strategy registered ::: "+strategy);
        pricingRegistry.put(strategy.getCategory(), strategy);
    }
	
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
		
		registerStrategy(new SedanPricingStrategy());
        registerStrategy(new VanPricingStrategy());
        registerStrategy(new SuvPricingStrategy());
        registerStrategy(new PickupTruckPricingStrategy());
		
	}

	@Override
	@Transactional
	public void reserveCar(ReservationRequestDTO reservationRequestDTO) {
		
		log.info("in reserveCar service ");
		
		//verify license number call 3rd party service
		boolean validLicense = true;
		// validLicense = reservationRequestDTO.getLicenseNo();
		if(!validLicense) {
			throw new IllegalArgumentException("license No ::: "+reservationRequestDTO.getLicenseNo());
		}
		
		
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
			
			 // 3. Handle Pessimistic/Optimistic locking check on Inventory table
			Optional<InventoryEntity> optInventory = 
					Optional.ofNullable(inventoryRepository.findByVehicleType(reservationRequestDTO.getVehicleType())
         .orElseThrow(() -> new IllegalArgumentException("Invalid vehicle category")));
	            
	        if (!optInventory.isPresent()) {
	            throw new IllegalStateException("No vehicles available in this category");
	        }
	        InventoryEntity inventoryEntity = optInventory.get();
	        // Deduct inventory
	        inventoryEntity.setQuantity(inventoryEntity.getQuantity()-1);
	        inventoryRepository.save(inventoryEntity);
		
		//insert vehicle request  to reservation entity and save
			ReservationEntity reservationEntity = new ReservationEntity();
			reservationEntity.setCustomer(savedCustomer);
			reservationEntity.setVehicleType(reservationRequestDTO.getVehicleType());
			reservationEntity.setStartDate(Timestamp.valueOf(reservationRequestDTO.getStartDate()));
			reservationEntity.setEndDate(Timestamp.valueOf(reservationRequestDTO.getEndDate()));
			reservationEntity.setEstimatedDailyMileage(reservationRequestDTO.getPerDayMileage());
			reservationEntity.setTotalCost(reservationRequestDTO.getTotalCost());
			reservationEntity.setStatus(ReservationStatus.RESERVED.toString());
			reservationEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			reservationEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			
			
			ReservationEntity savedReservation = reservationRepository.save(reservationEntity);
			log.info("saved reservation entity ::: "+savedReservation.getReservationId());
			
			//set data in reservationstatuscomm(outbox) entity and save
			ReservationStatusCommEntity reservationStatusCommEntity = new ReservationStatusCommEntity();
			//reservationStatusCommEntity.setEventId(UUID.randomUUID());
			reservationStatusCommEntity.setReservationId(savedReservation.getReservationId());
			reservationStatusCommEntity.setReservationType(savedReservation.getStatus());
			reservationStatusCommEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			reservationStatusCommEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			reservationStatusCommEntity.setProcessed(false);
			reservationStatusCommEntity.setEventType("COMM_AWAIT");
			reservationStatusRepository.saveAndFlush(reservationStatusCommEntity);		
			

	}

	@Override
	public boolean modifyReservation(Long reservationId, 
			ReservationRequestDTO reservationRequestDTO) {
			return false;	
	}

	@Override
	@Transactional
	public boolean cancelReservation(String reservationId) {
		
		 ReservationEntity reservationEntity =
				 reservationRepository.findByStringIdCustom(reservationId).orElseThrow(
						 () -> 
						 new ResourceNotFoundException("Reservation",
								 "ReservationId", String.valueOf(reservationId))
						 );
		 
		reservationEntity.setStatus("CANCELLED");
		reservationEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		reservationEntity.setEndDate(new Timestamp(System.currentTimeMillis()));
		reservationRepository.save(reservationEntity);
		
		 // Deduct inventory
		InventoryEntity inventory = inventoryRepository.findByVehicleType(reservationEntity.getVehicleType()).get();
        inventory.setQuantity(inventory.getQuantity() + 1);
        inventoryRepository.save(inventory);
        
      //set data in reservationstatuscomm(outbox) entity and save
		ReservationStatusCommEntity reservationStatusCommEntity = new ReservationStatusCommEntity();
		//reservationStatusCommEntity.setEventId(UUID.randomUUID());
		reservationStatusCommEntity.setReservationId(reservationEntity.getReservationId());
		reservationStatusCommEntity.setReservationType(reservationEntity.getStatus());
		reservationStatusCommEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		reservationStatusCommEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		reservationStatusCommEntity.setProcessed(false);
		reservationStatusCommEntity.setEventType("COMM_AWAIT");
		reservationStatusRepository.saveAndFlush(reservationStatusCommEntity);		
	
        
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public List<VehicleResponseDTO> getOptions(VehicleRequestDTO vehiclesRequestDTO) {
		
		log.info("in getOptions service ::"+vehiclesRequestDTO.getStartDate()+"=="+
				vehiclesRequestDTO.getEndDate());
		// 1. Fail early if backend validation detects invalid state
	    //if (!dmvService.verifyLicense(vehiclesRequestDTO.getLicenseNo())) {
	       // return Collections.emptyList(); 
	   // }

		
	    // 2. Fetch configurations for all categories from inventory table
	    List<InventoryEntity> inventoryConfigs = inventoryRepository.findAll();
	    
	    log.info("in inventory list size::"+inventoryConfigs.size());

	    // 3. Map categories via registry strategies matching DB parameters
	    return inventoryConfigs.stream()
	        .map(config -> {
	        		InventoryDTO inventoryDTO = new InventoryDTO(config.getVehicleType(),
	        				config.getQuantity(),config.getBasePriceTenDaysUnder(),
	        				config.getBasePriceTenDaysOver(),config.getLicenseCheckRequired(),
	        				config.getPricePerMile(),config.getVersion(),
	        				config.getCreatedAt(),config.getUpdatedAt());
	            PricingStrategy strategy = pricingRegistry.get(VehicleCategory.valueOf(config.getVehicleType()));
	            BigDecimal totalCost = strategy.calculateCost(vehiclesRequestDTO,inventoryDTO);
	            boolean availability = config.getQuantity() > 0;
	            
	            return new VehicleResponseDTO(config.getVehicleType(),
	            		vehiclesRequestDTO.getStartDate(),vehiclesRequestDTO.getEndDate(),
	            		vehiclesRequestDTO.getPerDayMileage(),totalCost, availability);
	        })
	        .sorted(Comparator.comparing(VehicleResponseDTO::getTotalCost)) // Ascending order
	        .toList();
		
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void publishEvent(ReservationStatusCommEntity event) {
		reservationStatusRepository.save(event);
	}

}
