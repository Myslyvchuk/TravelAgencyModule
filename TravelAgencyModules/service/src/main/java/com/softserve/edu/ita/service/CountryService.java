package com.softserve.edu.ita.service;

import java.util.List;

import com.softserve.edu.ita.service.dao.DaoFactory;
import com.softserve.edu.ita.service.entity.Country;

public class CountryService {
	public void addCountry(Country country) {
		DaoFactory.getInstance().getCountryDao().addElement(country);
	}
	public void updateCountry(Country country) {
		DaoFactory.getInstance().getCountryDao().updateElement(country);
	}
	public Country getCountryById(Long countryId) {
        return DaoFactory.getInstance().getCountryDao().getElementByID(countryId);
    }

    public List<Country> getAllCountry() {
        return DaoFactory.getInstance().getCountryDao().getAllElements();
    }

    public void deleteCountry(Country country) {
        DaoFactory.getInstance().getCountryDao().deleteElement(country);
    }
}
