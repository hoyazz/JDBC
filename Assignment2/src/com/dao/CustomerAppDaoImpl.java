package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerAppDaoImpl implements CustomerAppDao {
	
	private final String QUERY = "select * from Orders as o " +
			"join Customer as c on (c.customerNumber = o.customerNumber) " +
			"join Product as p on (p.productCode = o.productCode) " +
			"where c.customerNumber=?";
	private final String ORDERED_QUERY = "select * from Orders as o " +
			"join Customer as c on (c.customerNumber = o.customerNumber) " +
			"join Product as p on (p.productCode = o.productCode) " +
			"where c.customerNumber=? " +
			"order by p.price DESC " +
			"limit 1";
	Connection conn = null;
	
	public CustomerAppDaoImpl() {
		conn = ConnectionManager.getConnection();
	}
	
	@Override
	public Product getProduct(int code) {
		Product product = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select * from Product where productCode=?");
			stmt.setInt(1, code);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("productCode"),
						rs.getString("productName"),
						rs.getDouble("price"),
						rs.getInt("quantity"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
	}
	
	
	@Override
	public HashMap<Customer, Orders> getCustomerDetails() {
		HashMap<Customer, Orders> details = new HashMap<Customer, Orders>();
		Customer customer;
		Orders order;
		List<Product> items;
		try {
			Statement stmt1 = conn.createStatement();
			ResultSet rs1 = stmt1.executeQuery("select * from Customer");
			while (rs1.next()) {
				order = new Orders();
				items = new ArrayList<Product>();
				customer = new Customer(rs1.getInt("customerNumber"),
						rs1.getString("customerName"),
						rs1.getString("address"),
						rs1.getString("city"),
						rs1.getString("country"));
				
				PreparedStatement stmt2 = conn.prepareStatement(QUERY);
				stmt2.setInt(1, customer.getCustomerNumber());
				ResultSet rs2 = stmt2.executeQuery();
				while(rs2.next()) {
					Product product = new Product(rs2.getInt("productCode"),
							rs2.getString("productName"),
							rs2.getDouble("price"),
							rs2.getInt("o.quantity"));
					items.add(product);
				}
				rs2.close();
				stmt2.close();
				order.setItems(items);
				details.put(customer, order);
			}
			rs1.close();
			stmt1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return details;
	}

	@Override
	public HashMap<Customer, Orders> getCustomerDetails(int customerNum) {
		HashMap<Customer, Orders> details = new HashMap<Customer, Orders>();
		Orders order = new Orders();
		Customer customer = null;
		List<Product> items = new ArrayList<Product>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(QUERY);
			stmt.setInt(1, customerNum);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (customer == null) {
					customer = new Customer(rs.getInt("customerNumber"),
							rs.getString("customerName"),
							rs.getString("address"),
							rs.getString("city"),
							rs.getString("country"));
				}
				Product product = new Product(rs.getInt("productCode"),
						rs.getString("productName"),
						rs.getDouble("price"),
						rs.getInt("o.quantity"));
				items.add(product);
			}
			rs.close();
			stmt.close();
			order.setItems(items);
			details.put(customer, order);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return details;
	}
	
	@Override
	public void updateProduct(int code, int quantity) {
		try {
			/*
			PreparedStatement stmt = conn.prepareStatement(
					"update Product " +
					"set quantity=? " +
					"where productCode=?");
			stmt.setInt(1, quantity);
			stmt.setInt(2, code);
			
			int status = stmt.executeUpdate();
			if (status == 1) {
				System.out.println("[!] Successfully updated the quantity of product");
			} else {
				System.out.println("[-] An error has occurred while updating the product data");
			}
			stmt.close();
			*/
			
			PreparedStatement stmt = conn.prepareStatement(
					"select * from Product " +
					"where productCode=?",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stmt.setInt(1, code);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				rs.updateInt("quantity", quantity);
				rs.updateRow();
				System.out.println("[!] Successfully updated the quantity of productCode " + code + " to " + quantity);
			} else {
				System.out.println("[-] An error has occurred while updating the product data");
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(int customerNum, int productNum) {
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"delete from Orders " +
					"where customerNumber=? and productCode=?");
			stmt.setInt(1, customerNum);
			stmt.setInt(2, productNum);
			int status = stmt.executeUpdate();
			if (status == 1) {
				System.out.println("[!] Successfully removed product with productCode (" + productNum + ") from the order");
			} else {
				System.out.println("[-] An error has occurred while deleting the product data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Product getMax(int customerNum) {
		Product product = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(ORDERED_QUERY);
			stmt.setInt(1, customerNum);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("productCode"),
						rs.getString("productName"),
						rs.getDouble("o.price"),
						rs.getInt("o.quantity"));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
}
