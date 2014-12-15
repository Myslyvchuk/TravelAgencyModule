package com.softserve.edu.ita.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@ManyToOne
	private Hotel hotelID;
	@ManyToOne
	private Client clientID;
	@Column(name = "date_from")
	@Temporal(value = TemporalType.DATE)
	private Date date_from;
	@Column(name = "date_to")
	@Temporal(value = TemporalType.DATE)
	private Date date_to;

	public Booking() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_from() {
		return date_from;
	}

	public void setDate_from(Date date_from) {
		this.date_from = date_from;
	}

	public Date getDate_to() {
		return date_to;
	}

	public void setDate_to(Date date_to) {
		this.date_to = date_to;
	}

	public Hotel getHotelID() {
		return hotelID;
	}

	public void setHotelID(Hotel hotelID) {
		this.hotelID = hotelID;
	}

	public Client getClientID() {
		return clientID;
	}

	public void setClientID(Client clientID) {
		this.clientID = clientID;
	}

}
