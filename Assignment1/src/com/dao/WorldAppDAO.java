package com.dao;

import java.util.List;

public interface WorldAppDAO {
	public Details getDetails(int cityId);
	public List<Country> getAllCountry();
	public List<City> getAllCity();
	public List<Details> getCapital(boolean isCapital);
}
