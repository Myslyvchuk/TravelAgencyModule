package com.softserve.edu.ita.service;

import java.util.List;

import com.softserve.edu.ita.dao.implementation.DaoFactory;
import com.softserve.edu.ita.entity.City;

public class CityService {
	public void addCity(City city) {
		DaoFactory.getInstance().getCityDao().addElement(city);
	}
	public void updateCity(City city) {
		DaoFactory.getInstance().getCityDao().updateElement(city);
	}
	public City getCityById(Long cityId) {
        return DaoFactory.getInstance().getCityDao().getElementById(cityId);
    }

    public List<City> getAllCity() {
        return DaoFactory.getInstance().getCityDao().getAllElement();
    }

    public void deleteCity(City city) {
        DaoFactory.getInstance().getCityDao().deleteElement(city);
    }
}


