package com.cra.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.cra.constants.VehicleCategory;
import com.cra.dto.InventoryDTO;
import com.cra.dto.VehicleRequestDTO;
import com.cra.service.PricingStrategy;

@Service
public class SuvPricingStrategy implements PricingStrategy {

	@Override
	public VehicleCategory getCategory() {
		
		return VehicleCategory.SUV;
	}

	@Override
	public BigDecimal calculateCost(VehicleRequestDTO vehicleRequestDTO,
			InventoryDTO inventoryDTO) {
		
		long days = vehicleRequestDTO.getDurationInDays();
        double baseCost = days * 15.0;
        double mileageCost = days * vehicleRequestDTO.getPerDayMileage() * 0.50;
        return BigDecimal.valueOf(baseCost + mileageCost);
	}

}
