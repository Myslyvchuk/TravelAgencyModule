package com.softserve.edu.ita.app;

import com.softserve.edu.ita.dao.HibernateUtil;
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

public class App {

	public static void main(String[] args) {

		
		 GenerateData obj = new GenerateData();
		 
		 obj.GenerateDataForDB();
		
		/*Country country = new Country();
		City city = new City();
		Hotel hotel = new Hotel();
		Client client = new Client();
		Booking booking = new Booking();
		Visa visa = new Visa();

		CountryService cos = new CountryService();
		CityService cis = new CityService();
		HotelService his = new HotelService();
		ClientService cls = new ClientService();
		VisaService vs = new VisaService();
		BookingService bs = new BookingService();

		cos.addCountry(country);
		cis.addCity(city);
		his.addHotel(hotel);
		cls.addClient(client);
		vs.addVisa(visa);
		bs.addBooking(booking);*/
		HibernateUtil.closeFactory();

	}

}
