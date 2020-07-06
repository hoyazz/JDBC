package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorldAppDAOClass implements WorldAppDAO {

	List<Details> detailsList;
	List<City> cityList;
	List<Country> countryList;
	Connection conn;
	
	public WorldAppDAOClass(){
		conn = ConnectionFactory.getConnection();
		detailsList = new ArrayList<Details>();
		cityList = new ArrayList<City>();
		countryList = new ArrayList<Country>();
	}
	
	@Override
	public Details getDetails(int cityId) {
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select * from City " +
					"join Country on City.CountryId=Country.CountryId " +
					"where cityId=?");
			stmt.setInt(1, cityId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Details d = new Details();
				d.setCityId(rs.getInt("CityId"));
				d.setName(rs.getString("Name"));
				d.setCapital(rs.getBoolean("IsCapital"));
				d.setCountryId(rs.getInt("CountryId"));
				d.setCountryName(rs.getString("CountryName"));
				d.setPopulation(rs.getInt("Population"));
				return d;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Country> getAllCountry() {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Country");
			while(rs.next()) {
				Country c = new Country();
				c.setCountryId(rs.getInt("CountryId"));
				c.setCountryName(rs.getString("CountryName"));
				c.setPopulation(rs.getInt("Population"));
				countryList.add(c);
			}
			rs.close();
			stmt.close();
			return countryList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<City> getAllCity() {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from City");
			while(rs.next()) {
				City c = new City();
				c.setCityId(rs.getInt("CityId"));
				c.setName(rs.getString("Name"));
				c.setCapital(rs.getBoolean("IsCapital"));
				c.setCountryId(rs.getInt("CountryId"));
				cityList.add(c);
			}
			rs.close();
			stmt.close();
			return cityList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Details> getCapital(boolean isCapital) {
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select * from City " +
					"join Country on City.CountryId=Country.CountryId " +
					"where isCapital=?");
			stmt.setBoolean(1, isCapital);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Details d = new Details();
				d.setCityId(rs.getInt("CityId"));
				d.setName(rs.getString("Name"));
				d.setCapital(rs.getBoolean("IsCapital"));
				d.setCountryId(rs.getInt("CountryId"));
				d.setCountryName(rs.getString("CountryName"));
				d.setPopulation(rs.getInt("Population"));
				detailsList.add(d);
			}
			rs.close();
			stmt.close();
			return detailsList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
