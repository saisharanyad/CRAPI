package com.cra.entity;


import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name="reservation")
@Entity
public class ReservationEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	@Column(name="reservation_id")
    private String reservationId;

	@OneToOne
	@JoinColumn(name="customer_id",referencedColumnName="customer_id")
    private CustomerEntity customer;

    @Column(name="vehicle_type")
    private String vehicleType;
    
    @Column(name="start_date")
    private Timestamp startDate;
    
    @Column(name="end_date")
    private Timestamp endDate;
    
    @Column(name="estimated_daily_mileage")
    private Integer estimatedDailyMileage;
    
    @Column(name="total_cost")
    private BigDecimal totalCost;
    
    @Column(name="status")
    private String status;
    
    @Column(name="created_at")
    private Timestamp createdAt;
    
    @Column(name="updated_at")
    private Timestamp updatedAt;
    

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}


	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Integer getEstimatedDailyMileage() {
		return estimatedDailyMileage;
	}

	public void setEstimatedDailyMileage(Integer estimatedDailyMileage) {
		this.estimatedDailyMileage = estimatedDailyMileage;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "ReservationEntity [reservationId=" + reservationId + ", customer=" + customer + ", vehicleType="
				+ vehicleType + ", startDate=" + startDate + ", endDate=" + endDate + ", estimatedDailyMileage="
				+ estimatedDailyMileage + ", totalCost=" + totalCost + ", status=" + status + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}


	
	

	
    
      
    
    
}
