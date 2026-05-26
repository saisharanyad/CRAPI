package com.cra.entity;


import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="inventory")
@Entity
public class InventoryEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="inventory_id")
    private Long inventoryId;

    @Column(name="vehicle_type")
    private String vehicleType;

    @Column(name="quantity")
    private Long quantity;
    
    @Column(name="base_price_under_10_days")
    private BigDecimal basePriceTenDaysUnder;
    
    @Column(name="base_price_over_10_days")
    private BigDecimal basePriceTenDaysOver;
    
    @Column(name="license_check_required")
    private Boolean licenseCheckRequired;
    
    @Column(name="price_per_mile")
    private BigDecimal pricePerMile;
    
    @Column(name="version")
    private Long version;

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
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

	@Override
	public String toString() {
		return "InventoryEntity [inventoryId=" + inventoryId + ", vehicleType=" + vehicleType + ", quantity=" + quantity
				+ ", basePriceTenDaysUnder=" + basePriceTenDaysUnder + ", basePriceTenDaysOver=" + basePriceTenDaysOver
				+ ", licenseCheckRequired=" + licenseCheckRequired + ", pricePerMile=" + pricePerMile + ", version="
				+ version + "]";
	}
    
    
    
    
}
