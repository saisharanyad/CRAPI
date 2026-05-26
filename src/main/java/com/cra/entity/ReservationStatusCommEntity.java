package com.cra.entity;


import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="outbox_event")
@Entity
public class ReservationStatusCommEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="event_id")
    private UUID eventId;
	
	@Column(name="aggregate_type")
    private String reservationType;
	
	@Column(name="aggregate_id")
	private String resrevationId;

    @Column(name="event_type")
    private String eventType;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="processed")
    private Boolean processed;

	public UUID getEventId() {
		return eventId;
	}

	public void setEventId(UUID eventId) {
		this.eventId = eventId;
	}

	public String getReservationType() {
		return reservationType;
	}

	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}

	public String getResrevationId() {
		return resrevationId;
	}

	public void setResrevationId(String resrevationId) {
		this.resrevationId = resrevationId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getProcessed() {
		return processed;
	}

	public void setProcessed(Boolean processed) {
		this.processed = processed;
	}

	@Override
	public String toString() {
		return "ReservationStatusCommEntity [eventId=" + eventId + ", reservationType=" + reservationType
				+ ", resrevationId=" + resrevationId + ", eventType=" + eventType + ", createdAt=" + createdAt
				+ ", processed=" + processed + "]";
	}
    
       
    
}
