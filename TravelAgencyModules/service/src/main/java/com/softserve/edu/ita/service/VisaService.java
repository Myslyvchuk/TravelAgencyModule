package com.softserve.edu.ita.service;

import java.util.List;

import com.softserve.edu.ita.dao.implementation.DaoFactory;
import com.softserve.edu.ita.entity.Visa;

public class VisaService {
	
	public void addVisa(Visa visa) {
		DaoFactory.getInstance().getVisaDao().addElement(visa);
	}
	public void updateVisa(Visa visa) {
		DaoFactory.getInstance().getVisaDao().updateElement(visa);
	}
	public Visa getVisaById(Long visaId) {
        return DaoFactory.getInstance().getVisaDao().getElementById(visaId);
    }

    public List<Visa> getAllVisa() {
        return DaoFactory.getInstance().getVisaDao().getAllElement();
    }

    public void deleteVisa(Visa visa) {
        DaoFactory.getInstance().getVisaDao().deleteElement(visa);
    }

}
