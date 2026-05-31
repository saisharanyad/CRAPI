package com.cra.dto;


public class ReservationRequestDTO {
		
		private AddressDTO addressDTO;
		private CustomerDTO customerDTO;
		private VehicleRequestDTO vehicleRequestDTO;
		
		
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
		public VehicleRequestDTO getVehicleRequestDTO() {
			return vehicleRequestDTO;
		}
		public void setVehicleRequestDTO(VehicleRequestDTO vehicleRequestDTO) {
			this.vehicleRequestDTO = vehicleRequestDTO;
		}
		
		
		
	    
}
