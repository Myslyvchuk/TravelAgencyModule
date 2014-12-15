package com.softserve.edu.ita.service;

import java.util.List;

import com.softserve.edu.ita.dao.DaoFactory;
import com.softserve.edu.ita.entity.Booking;

public class BookingService {
	public void addBooking(Booking booking) {
		DaoFactory.getInstance().getBookingDao().addElement(booking);
	}
	public void updateBooking(Booking booking) {
		DaoFactory.getInstance().getBookingDao().updateElement(booking);
	}
	public Booking getBookingById(Long bookingId) {
        return DaoFactory.getInstance().getBookingDao().getElementByID(bookingId);
    }

    public List<Booking> getAllBooking() {
        return DaoFactory.getInstance().getBookingDao().getAllElements();
    }

    public void deleteBooking(Booking booking) {
        DaoFactory.getInstance().getBookingDao().deleteElement(booking);
    }

}
