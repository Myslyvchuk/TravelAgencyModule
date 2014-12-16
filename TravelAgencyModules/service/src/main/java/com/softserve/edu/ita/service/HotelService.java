package com.softserve.edu.ita.service;

import java.util.List;

import com.softserve.edu.ita.dao.DaoFactory;
import com.softserve.edu.ita.entity.Hotel;

public class HotelService {
	
	public void addHotel(Hotel hotel) {
		DaoFactory.getInstance().getHotelDao().addElement(hotel);
	}
	public void updateHotel(Hotel hotel) {
		DaoFactory.getInstance().getHotelDao().updateElement(hotel);
	}
	public Hotel getHotelById(Long hotelId) {
        return DaoFactory.getInstance().getHotelDao().getElementByID(hotelId);
    }

    public List<Hotel> getAllHotel() {
        return DaoFactory.getInstance().getHotelDao().getAllElements();
    }

    public void deleteHotel(Hotel hotel) {
        DaoFactory.getInstance().getHotelDao().deleteElement(hotel);
    }

}
