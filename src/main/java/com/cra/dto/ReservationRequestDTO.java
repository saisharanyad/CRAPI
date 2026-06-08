package com.cra.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationRequestDTO {
		
		private AddressDTO addressDTO;
		private CustomerDTO customerDTO;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
		private LocalDateTime startDate;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
		private LocalDateTime endDate;
		private String licenseNo;
		private Integer perDayMileage;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
		private LocalDateTime dateOfBirth;
		private String vehicleType;
		private BigDecimal totalCost;
		
		public AddressDTO getAddressDTO() {
			return addressDTO;
		}
		public void setAddressDTO(AddressDTO addressDTO) {
			this.addressDTO = addressDTO;
		}
		public CustomerDTO getCustomerDTO() {
			return customerDTO;
		}
		public void setCustomerDTO(CustomerDTO customerDTO) {
			this.customerDTO = customerDTO;
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

	public String getLicenseNo() {
			return licenseNo;
		}

		public void setLicenseNo(String licenseNo) {
			this.licenseNo = licenseNo;
		}

		public Integer getPerDayMileage() {
			return perDayMileage;
		}

		public void setPerDayMileage(Integer perDayMileage) {
			this.perDayMileage = perDayMileage;
		}


		public LocalDateTime getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(LocalDateTime dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public BigDecimal getTotalCost() {
			return totalCost;
		}

		public void setTotalCost(BigDecimal totalCost) {
			this.totalCost = totalCost;
		}
		
		
}
