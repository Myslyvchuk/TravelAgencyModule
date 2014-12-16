package com.softserve.edu.ita.app;

import com.softserve.edu.ita.dao.HibernateUtil;
import com.softserve.edu.ita.entity.*;
import com.softserve.edu.ita.service.*;

public class App {

	public static void main(String[] args) {

		Country country1 = new Country();
		City city1 = new City();
		Hotel hotel1 = new Hotel();
		Client client1 = new Client();
		Visa visa1 = new Visa();
		Booking booking1 = new Booking();

		country1.setCountry("Guatemala");

		city1.setCity("Guantanamo");
		city1.setCountryID(country1);

		client1.setName("Test");
		client1.setSurname("Test");
		client1.setAge(100);

		hotel1.setName("Gavana");
		hotel1.setCityID(city1);

		booking1.setHotelID(hotel1);
		booking1.setClientID(client1);
		booking1.setDate_from(new java.sql.Date((long) (new java.util.Date())
				.getTime() + 60 * 60 * 24 * 1000 * 4));
		booking1.setDate_to(new java.sql.Date((long) (new java.util.Date())
				.getTime() + 60 * 60 * 24 * 1000 * 4));

		visa1.setClientID(client1);
		visa1.setCountryID(country1);
		visa1.setDate_from(new java.sql.Date((long) (new java.util.Date())
				.getTime() + 60 * 60 * 24 * 1000 * 4));
		visa1.setDate_to(new java.sql.Date((long) (new java.util.Date())
				.getTime() + 60 * 60 * 24 * 1000 * 4));

		CityService cis = new CityService();
		ClientService cls = new ClientService();
		CountryService cos = new CountryService();
		HotelService hs = new HotelService();
		VisaService vs = new VisaService();
		BookingService bs = new BookingService();

		cos.addCountry(country1);
		cis.addCity(city1);
		cls.addClient(client1);
		hs.addHotel(hotel1);
		vs.addVisa(visa1);
		bs.addBooking(booking1);

		HibernateUtil.closeFactory();
	}

}
