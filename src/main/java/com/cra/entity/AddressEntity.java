package com.cra.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="address")
@Entity
public class AddressEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
    private Long addressId;

    @Column(name="street_no")
    private String streetNo;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;
    
    @Column(name="country")
    private String country;
    
    @Column(name="zipcode")
    private String zipcode;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "AddressEntity [addressId=" + addressId + ", streetNo=" + streetNo + ", city=" + city + ", state="
				+ state + ", country=" + country + ", zipcode=" + zipcode + "]";
	}
    
    
    

	

	
    
    
    
}
