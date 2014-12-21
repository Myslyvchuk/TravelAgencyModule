package com.softserve.edu.ita.app;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import antlr.collections.List;

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

	private static final String[] COUNTRY = { "Italy", "USA", "United Kingdom",
			"France", "Switzerland", "Portugues", "Spain", "Germany", "Poland",
			"Moldova" };
	private static final String[] CLIENT_NAME = { "Vasyl", "Nazar", "Pavlo",
			"Bohdan", "Olexander", "Anatolii", "Yurii", "Andrii", "Oleg",
			"Igor" };
	private static final String[] LAST_NAME = { "Antonov", "Voytenko",
			"Mazurak", "Yavorovskii", "Bzdun'", "Kit", "Ivanenko", "Koromets'",
			"Haluschak", "Ivanytskii" };
	private static final String[] CITY = { "Chicago", "Bern", "Krakow",
			"Munchen", "Paris", "Nola", "London", "Lisabon", "Barcelona",
			"Madrid" };
	private static final String[] HOTEL = { "Paradise", "Hayat", "Resort",
			"Bukovel", "Redisson Blu", "Natali", "Garden", "Rusvelt Hotel",
			"Pacific Palm", "Moonlight" };

	public void GenerateDataForDB() {

		ArrayList<Country> countryList = new ArrayList<Country>();
		CountryService cos = new CountryService();
		for (int i = 0; i < COUNTRY.length; i++) {
			countryList.add(new Country());
			countryList.get(i).setCountry(COUNTRY[i]);
			cos.addCountry(countryList.get(i));

		}

		ArrayList<City> cityList = new ArrayList<City>();
		CityService cis = new CityService();
		for (int i = 0; i < CITY.length; i++) {
			cityList.add(new City());
			cityList.get(i).setCity(CITY[i]);
			cityList.get(i).setCountry(countryList.get(i));
			cis.addCity(cityList.get(i));

		}

		ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
		HotelService hs = new HotelService();
		for (int i = 0; i < HOTEL.length; i++) {
			hotelList.add(new Hotel());
			hotelList.get(i).setName(HOTEL[i]);
			hotelList.get(i).setCity(cityList.get(i));
			hs.addHotel(hotelList.get(i));

		}
		Random r = new Random(44);
		for (int i = 0; i < 1; i++) {

			Client client1 = new Client();
			Booking booking1 = new Booking();
			Visa visa1 = new Visa();

		
			int year = r.nextInt(2017 - 2013) + 113;
			int month = r.nextInt(13 - 1) + 1;
			int dayOfYear = r.nextInt(31 - 1) + 1;

			client1.setName(CLIENT_NAME[r.nextInt(10)]);
			client1.setLastname(LAST_NAME[r.nextInt(10)]);
			client1.setAge(r.nextInt(60 - 20) + 20);

			booking1.setHotel(hotelList.get(r.nextInt(10)));
			booking1.setClient(client1);
			booking1.setDateFrom(new Date(year, month, dayOfYear));
			booking1.setDateTo(new Date(year, month, dayOfYear
					+ r.nextInt(6 - 1) + 1));

			visa1.setClient(client1);
			visa1.setCountry(countryList.get(r.nextInt(10)));
			visa1.setDateFrom(new Date(year, month, dayOfYear));
			visa1.setDateTo(new Date(year + r.nextInt(1), month
					+ r.nextInt(6 - 3) + 3, dayOfYear));

			ClientService cls = new ClientService();
			VisaService vs = new VisaService();
			BookingService bs = new BookingService();

			cls.addClient(client1);
			vs.addVisa(visa1);
			bs.addBooking(booking1);

		}

	}
}
