package com.softserve.edu.ita.app;

import java.sql.Date;
import java.util.Random;

import com.softserve.edu.ita.entity.Booking;
import com.softserve.edu.ita.entity.City;
import com.softserve.edu.ita.entity.Client;
import com.softserve.edu.ita.entity.Country;
import com.softserve.edu.ita.entity.Hotel;
import com.softserve.edu.ita.entity.Visa;
import com.softserve.edu.ita.service.BookingService;
import com.softserve.edu.ita.service.CityService;
import com.softserve.edu.ita.service.ClientService;
import com.softserve.edu.ita.service.CountryService;
import com.softserve.edu.ita.service.HotelService;
import com.softserve.edu.ita.service.VisaService;

public class GenerateData {
	public static Random rand = new Random();
	private static final String[] CLIENT_NAME = { "Vasyl", "Nazar", "Pavlo",
			"Bohdan", "Olexander", "Anatolii", "Yurii", "Andrii", "Oleg",
			"Igor" };
	private static final String[] LAST_NAME = { "Antonov", "Voytenko",
			"Mazurak", "Yavorovskii", "Bzdun'", "Kit", "Ivanenko", "Koromets'",
			"Haluschak", "Ivanytskii" };
	private static final String[] COUNTRY = { "Italy", "USA", "United Kingdom",
			"France", "Switzerland", "Portugues", "Spain", "Germany", "Poland",
			"Moldova" };
	private static final String[] CITY = { "Chicago", "Bern", "Krakow",
			"Munchen", "Paris", "Nola", "London", "Lisabon", "Barcelona",
			"Madrid" };
	private static final String[] HOTEL = { "Paradise", "Hayat", "Resort",
			"Bukovel", "Redisson Blu", "Natali", "Garden", "Rusvelt Hotel",
			"Pacific Palm", "Moonlight" };

	public void GenerateDataForDB() {

		Country country1 = new Country();
		City city1 = new City();
		Hotel hotel1 = new Hotel();
		Client client1 = new Client();
		Booking booking1 = new Booking();
		Visa visa1 = new Visa();

		Random r = new Random();
		int year = r.nextInt(2017 - 2013) + 113;

		int month = r.nextInt(13 - 1) + 1;

		int dayOfYear = r.nextInt(31 - 1) + 1;

		country1.setCountry(COUNTRY[rand.nextInt(10)]);

		city1.setCity(CITY[rand.nextInt(10)]);
		city1.setCountry(country1);

		client1.setName(CLIENT_NAME[rand.nextInt(10)]);
		client1.setLastname(LAST_NAME[rand.nextInt(10)]);
		client1.setAge(100);

		hotel1.setName(HOTEL[rand.nextInt(10)]);
		hotel1.setCity(city1);

		booking1.setHotel(hotel1);
		booking1.setClient(client1);
		booking1.setDateFrom(new Date(year, month, dayOfYear));
		booking1.setDateTo(new Date(year, month, dayOfYear));

		visa1.setClient(client1);
		visa1.setCountry(country1);
		visa1.setDateFrom(new Date(year, month, dayOfYear));
		visa1.setDateTo(new Date(year, month, dayOfYear));

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

	}

}
