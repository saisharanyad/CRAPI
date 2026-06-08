package com.cra.service;

import java.math.BigDecimal;

import com.cra.constants.VehicleCategory;
import com.cra.dto.InventoryDTO;
import com.cra.dto.VehicleRequestDTO;

public interface PricingStrategy {
	
	  	VehicleCategory getCategory();
	  	BigDecimal calculateCost(VehicleRequestDTO vehicleRequestDTO,
	    		InventoryDTO inventoryDTO);
		

}
