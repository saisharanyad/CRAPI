package com.cra.dto;

import java.util.Date;

public class VehicleRequestDTO {
	
	private Date startDate;
	private Date endDate;
	private String licenseNo;
	private Integer perDayMileage;
	private Date dateOfBirth;
	
	
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
