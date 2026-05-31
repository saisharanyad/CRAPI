package com.cra.dto;

import java.util.Date;

import com.cra.constants.Vehicle;

public class VehicleResponseDTO {

	private Double totalPrice;
	private Vehicle vehicleType;
	private Date startDate;
	private Date endDate;
	private Integer perDayMileage;
	
	
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Vehicle getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(Vehicle vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getPerDayMileage() {
		return perDayMileage;
	}
	public void setPerDayMileage(Integer perDayMileage) {
		this.perDayMileage = perDayMileage;
	}
	
	
}
