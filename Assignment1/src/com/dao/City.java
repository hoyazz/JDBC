package com.dao;

public class City {
	private int cityId;
	private String name;
	private boolean isCapital;
	private int CountryId;
	
	public City() {
		
	}
	
	public City(int cityId, String name, boolean isCapital, int CountryId) {
		super();
		this.cityId = cityId;
		this.name = name;
		this.isCapital = isCapital;
		this.CountryId = CountryId;
	}

	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isCapital() {
		return isCapital;
	}
	public void setCapital(boolean isCapital) {
		this.isCapital = isCapital;
	}
	public int getCountryId() {
		return CountryId;
	}
	
	public void setCountryId(int countryId) {
		CountryId = countryId;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", name=" + name + ", isCapital=" + isCapital + ", CountryId=" + CountryId
				+ "]";
	}

}
