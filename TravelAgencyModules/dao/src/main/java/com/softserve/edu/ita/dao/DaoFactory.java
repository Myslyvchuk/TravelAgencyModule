package com.softserve.edu.ita.dao;


public class DaoFactory {
	private CountryDAO countryDao = null;
	private CityDAO cityDao = null;
	private HotelDAO hotelDao = null;
	private ClientDAO clientDao = null;
	private VisaDAO visaDao = null;
	private BookingDAO bookingDao = null;
	

	private static DaoFactory instance = null;

	private DaoFactory() {
		this.countryDao = new CountryDAO();
		this.cityDao = new CityDAO();
		this.hotelDao = new HotelDAO();
		this.clientDao = new ClientDAO();
		this.visaDao = new VisaDAO();
		this.bookingDao = new BookingDAO();
		
	}

	public static synchronized DaoFactory getInstance() {
		if (instance == null) {
			instance = new DaoFactory();
		}
		return instance;
	}

	public CountryDAO getCountryDao() {
		return countryDao;
	}

	public CityDAO getCityDao() {
		return cityDao;
	}

	public HotelDAO getHotelDao() {
		return hotelDao;
	}

	public ClientDAO getClientDao() {
		return clientDao;
	}

	public VisaDAO getVisaDao() {
		return visaDao;
	}

	public BookingDAO getBookingDao() {
		return bookingDao;
	}


	
}
