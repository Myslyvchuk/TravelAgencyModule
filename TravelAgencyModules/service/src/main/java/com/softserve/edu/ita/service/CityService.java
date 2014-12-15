package com.softserve.edu.ita.service;

import java.util.List;

import com.softserve.edu.ita.service.dao.DaoFactory;
import com.softserve.edu.ita.service.entity.City;

public class CityService {
	public void addCity(City city) {
		DaoFactory.getInstance().getCityDao().addElement(city);
	}
	public void updateCity(City city) {
		DaoFactory.getInstance().getCityDao().updateElement(city);
	}
	public City getCityById(Long cityId) {
        return DaoFactory.getInstance().getCityDao().getElementByID(cityId);
    }

    public List<City> getAllCity() {
        return DaoFactory.getInstance().getCityDao().getAllElements();
    }

    public void deleteCity(City city) {
        DaoFactory.getInstance().getCityDao().deleteElement(city);
    }
}


