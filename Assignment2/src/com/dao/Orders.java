package com.dao;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	private int orderNumber;
	private int customerNumber;
	private int productCode;
	private double price;
	private List<Product> itemList;
	
	public Orders() {
		itemList = new ArrayList<Product>();
	}
	
	public Orders(int orderNumber, int customerNumber, int productCode, double price) {
		super();
		this.orderNumber = orderNumber;
		this.customerNumber = customerNumber;
		this.productCode = productCode;
		this.price = price;
		itemList = new ArrayList<Product>();
	}

	public List<Product> getItems() {
		return itemList;
	}

	public void setItems(List<Product> items) {
		this.itemList = items;
	}

	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
