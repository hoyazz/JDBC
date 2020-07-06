package com.dao;

public class Details {
	private int countryId;
	private String countryName;
	private int population;
	private int cityId;
	private String name;
	private boolean isCapital;
	
	public Details() {
		
	}
	
	public Details(int countryId, String countryName, int population, int cityId, String name, boolean isCapital) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.population = population;
		this.cityId = cityId;
		this.name = name;
		this.isCapital = isCapital;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
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

	@Override
	public String toString() {
		return "Details [countryId=" + countryId + ", countryName=" + countryName + ", population=" + population
				+ ", cityId=" + cityId + ", name=" + name + ", isCapital=" + isCapital + "]";
	}
	
	
}
