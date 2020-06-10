package com.cognizant.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long custId;
	private String firstName;
	private String lastName;
	private String adresssLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipcode;
	private LocalDate created;
	private LocalDate lastUpdated;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String firstName, String lastName, String adresssLine1, String addressLine2, String city,
			String state, String zipcode, LocalDate created, LocalDate lastUpdated) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.adresssLine1 = adresssLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.created = created;
		this.lastUpdated = lastUpdated;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAdresssLine1() {
		return adresssLine1;
	}
	public void setAdresssLine1(String adresssLine1) {
		this.adresssLine1 = adresssLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public LocalDate getCreated() {
		return created;
	}
	public void setCreated(LocalDate created) {
		this.created = created;
	}
	public LocalDate getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
}
