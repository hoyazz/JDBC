package com.dao;

import java.util.HashMap;

public class MainClass {
	public static void main(String[] args) {
		CustomerAppDao dao = new CustomerAppDaoImpl();
		
		System.out.println("-----Print All Customers and their Order/Product-----");
		HashMap<Customer, Orders> details = dao.getCustomerDetails();
		
		for (Customer c : details.keySet()) {
			System.out.println(c);
			for (Product p : details.get(c).getItems()) {
				System.out.println("\t" + p);				
			}
		}
		
		System.out.println("\n\n-----Update Product Quantity-----");
		System.out.println("Before the update: " + dao.getProduct(4));
		dao.updateProduct(4, 99);
		System.out.println("After the update: " + dao.getProduct(4));
		
		System.out.println("\n\n-----Delete Order-----");
		System.out.println("Before the delete:");
		details = dao.getCustomerDetails(1);
		for (Customer c : details.keySet()) {
			System.out.println(c);
			for (Product p : details.get(c).getItems()) {
				System.out.println("\t" + p);				
			}
		}
		
		dao.deleteOrder(1, 3);
		
		System.out.println("\nAfter the delete");
		details = dao.getCustomerDetails(1);
		for (Customer c : details.keySet()) {
			System.out.println(c);
			for (Product p : details.get(c).getItems()) {
				System.out.println("\t" + p);				
			}
		}
		
		System.out.println("\n\n-----Print the most expensive product purchased by a Customer-----");
		System.out.println("Customer Detail");
		details = dao.getCustomerDetails(1);
		for (Customer c : details.keySet()) {
			System.out.println(c);
			for (Product p : details.get(c).getItems()) {
				System.out.println("\t" + p);				
			}
		}
		System.out.println("The most expensive product purchased by the Customer is:\n\t" + dao.getMax(1));
		
		ConnectionManager.close();
	}
}
