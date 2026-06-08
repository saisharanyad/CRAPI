package com.cra.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.cra.constants.VehicleCategory;
import com.cra.dto.InventoryDTO;
import com.cra.dto.VehicleRequestDTO;
import com.cra.service.PricingStrategy;

@Service
public class SedanPricingStrategy implements PricingStrategy {

	@Override
	public VehicleCategory getCategory() {
		
		return VehicleCategory.SEDAN;
	}

	@Override
	public BigDecimal calculateCost(VehicleRequestDTO vehicleRequestDTO,
			InventoryDTO inventoryDTO) {
		long days = vehicleRequestDTO.getDurationInDays();
        BigDecimal dailyRate = (days < 10) ? inventoryDTO.getBasePriceTenDaysUnder()
        		: inventoryDTO.getBasePriceTenDaysOver();
        return dailyRate.multiply(BigDecimal.valueOf(days));
	}

}
