package com.cra.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class VehicleRequestDTO {
	
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String licenseNo;
	private Integer perDayMileage;
	private Date dateOfBirth;


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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
	
}
