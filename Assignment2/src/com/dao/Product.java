package com.dao;

import java.text.NumberFormat;
import java.util.Locale;

public class Product {
	private int productCode;
	private String productName;
	private double price;
	private int quantity;
	
	public Product(int productCode, String productName, double price, int quantity) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		Locale locale = new Locale("en", "US");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		return "Product [productCode=" + productCode + ", productName=" + productName + ", price=" + currencyFormatter.format(price)
				+ ", quantity=" + quantity + "]";
	}
}
