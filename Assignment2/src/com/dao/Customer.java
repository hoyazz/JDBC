package com.dao;

public class Customer {
	private int customerNumber;
	private String customerName;
	private String address;
	private String city;
	private String country;
	
	public Customer(int customerNumber, String customerName, String address, String city, String country) {
		super();
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.address = address;
		this.city = city;
		this.country = country;
	}
	
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", customerName=" + customerName + ", address=" + address
				+ ", city=" + city + ", country=" + country + "]";
	}

}
