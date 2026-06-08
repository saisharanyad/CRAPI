package com.cra.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import com.cra.constants.VehicleCategory;

public class VehicleResponseDTO {

	
	private String vehicleType;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Integer perDayMileage;
	private BigDecimal totalCost;
	private Boolean isAvailable;
	
	public VehicleResponseDTO(String vehicleType,LocalDateTime startDate,LocalDateTime endDate,
			Integer perDayMileage,BigDecimal totalCost,Boolean isAvailable) {
		this.vehicleType = vehicleType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.perDayMileage = perDayMileage;
		this.totalCost = totalCost;
		this.isAvailable = isAvailable;
	}
	
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public Integer getPerDayMileage() {
		return perDayMileage;
	}
	public void setPerDayMileage(Integer perDayMileage) {
		this.perDayMileage = perDayMileage;
	}
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
}
