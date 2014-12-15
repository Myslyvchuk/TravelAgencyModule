package com.softserve.edu.ita.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "visa")
public class Visa {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@ManyToOne
	private Client clientID;
	@ManyToOne
	private Country countryID;
	@Column(name = "date_from")
	@Temporal(value = TemporalType.DATE)
	private Date date_from;
	@Column(name = "date_to")
	@Temporal(value = TemporalType.DATE)
	private Date date_to;

	public Visa() {
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

	public Client getClientID() {
		return clientID;
	}

	public void setClientID(Client clientID) {
		this.clientID = clientID;
	}

	public Country getCountryID() {
		return countryID;
	}

	public void setCountryID(Country countryID) {
		this.countryID = countryID;
	}

}