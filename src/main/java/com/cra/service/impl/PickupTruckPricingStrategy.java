package com.cra.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.cra.constants.VehicleCategory;
import com.cra.dto.InventoryDTO;
import com.cra.dto.VehicleRequestDTO;
import com.cra.service.PricingStrategy;

@Service
public class PickupTruckPricingStrategy implements PricingStrategy {

	@Override
	public VehicleCategory getCategory() {
		
		return VehicleCategory.PICKUP_TRUCK;
	}

	@Override
	public BigDecimal calculateCost(VehicleRequestDTO vehicleRequestDTO,
			InventoryDTO inventoryDTO) {
	
		return inventoryDTO.getBasePriceTenDaysUnder().multiply(BigDecimal.valueOf(vehicleRequestDTO.
				getDurationInDays()));
	}

}
