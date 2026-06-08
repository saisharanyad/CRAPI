package com.cra.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;

public class InventoryDTO {
	
	private String vehicleType;
	private Long quantity;
    private BigDecimal basePriceTenDaysUnder;
    private BigDecimal basePriceTenDaysOver;
    private Boolean licenseCheckRequired;
    private BigDecimal pricePerMile;
    private Long version;  
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
    
    public InventoryDTO(String vehicleType,Long quantity,
    		BigDecimal basePriceTenDaysUnder,
     BigDecimal basePriceTenDaysOver,
     Boolean licenseCheckRequired,
     BigDecimal pricePerMile,
     Long version, 
     Timestamp createdAt,
     Timestamp updatedAt 
     ) {
    		this.vehicleType = vehicleType;
    		this.quantity = quantity;
    		this.basePriceTenDaysUnder = basePriceTenDaysUnder;
    		this.basePriceTenDaysOver = basePriceTenDaysOver;
    		this.licenseCheckRequired = licenseCheckRequired;
    		this.pricePerMile = pricePerMile;
    		this.version = version;
    		this.createdAt = createdAt;
    		this.updatedAt = updatedAt;
    }
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getBasePriceTenDaysUnder() {
		return basePriceTenDaysUnder;
	}
	public void setBasePriceTenDaysUnder(BigDecimal basePriceTenDaysUnder) {
		this.basePriceTenDaysUnder = basePriceTenDaysUnder;
	}
	public BigDecimal getBasePriceTenDaysOver() {
		return basePriceTenDaysOver;
	}
	public void setBasePriceTenDaysOver(BigDecimal basePriceTenDaysOver) {
		this.basePriceTenDaysOver = basePriceTenDaysOver;
	}
	public Boolean getLicenseCheckRequired() {
		return licenseCheckRequired;
	}
	public void setLicenseCheckRequired(Boolean licenseCheckRequired) {
		this.licenseCheckRequired = licenseCheckRequired;
	}
	public BigDecimal getPricePerMile() {
		return pricePerMile;
	}
	public void setPricePerMile(BigDecimal pricePerMile) {
		this.pricePerMile = pricePerMile;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
    

}
