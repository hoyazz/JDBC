package com.dao;

public class MainClass {
	public static void main(String[] args) {
		WorldAppDAO dao = new WorldAppDAOClass();
		
		System.out.println("-----Displaying all records in City-----");
		for (City c : dao.getAllCity()) {
			System.out.println(c);
		}

		System.out.println("\n\n-----Displaying all records in Country-----");
		for (Country c : dao.getAllCountry()) {
			System.out.println(c);
		}
		
		System.out.println("\n\n-----Displaying country and city details for cityId = 3-----");
		System.out.println(dao.getDetails(3));

		System.out.println("\n\n-----Displaying country and city details for isCapital = Y-----");
		for (Details d : dao.getCapital(true)) {
			System.out.println(d);
		}
	}
}
