package com.dao;

import java.util.HashMap;

public interface CustomerAppDao {
	public HashMap<Customer, Orders> getCustomerDetails();
	public HashMap<Customer, Orders> getCustomerDetails(int customerNum);
	public void updateProduct(int code, int quantity);
	public void deleteOrder(int customerNum, int productNum);
	public Product getProduct(int code);
	public Product getMax(int customerNum);
}
