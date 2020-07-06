package com.dao;

public class Country {
	private int CountryId;
	private String CountryName;
	private int Population;
	
	public Country() {
		
	}

	public Country(int countryId, String countryName, int population) {
		super();
		CountryId = countryId;
		CountryName = countryName;
		Population = population;
	}

	public int getCountryId() {
		return CountryId;
	}

	public void setCountryId(int countryId) {
		CountryId = countryId;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	public int getPopulation() {
		return Population;
	}

	public void setPopulation(int population) {
		Population = population;
	}

	@Override
	public String toString() {
		return "Country [CountryId=" + CountryId + ", CountryName=" + CountryName + ", Population=" + Population + "]";
	}
	
	
}
