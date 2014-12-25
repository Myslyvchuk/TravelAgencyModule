package com.softserve.edu.ita.service;

import java.util.List;

import com.softserve.edu.ita.dao.implementation.DaoFactory;
import com.softserve.edu.ita.entity.Country;

public class CountryService {
	public void addCountry(Country country) {
		DaoFactory.getInstance().getCountryDao().addElement(country);
	}
	public void updateCountry(Country country) {
		DaoFactory.getInstance().getCountryDao().updateElement(country);
	}
	public Country getCountryById(Long countryId) {
        return DaoFactory.getInstance().getCountryDao().getElementById(countryId);
    }

    public List<Country> getAllCountry() {
        return DaoFactory.getInstance().getCountryDao().getAllElement();
    }

    public void deleteCountry(Country country) {
        DaoFactory.getInstance().getCountryDao().deleteElement(country);
    }
}
