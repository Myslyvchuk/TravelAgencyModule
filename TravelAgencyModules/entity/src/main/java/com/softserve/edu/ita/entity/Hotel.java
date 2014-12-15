package com.softserve.edu.ita.entity;


import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {
	@Id
	@GeneratedValue
	private int id;
	@Column (name = "name", length = 32)
	private String name;
	@ManyToOne
	private City cityID;
	@OneToMany(mappedBy = "hotelID", cascade = CascadeType.PERSIST)
	private Set<Booking> booking;
	public Hotel() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public City getCityID() {
		return cityID;
	}
	public void setCityID(City cityID) {
		this.cityID = cityID;
	}
	
	
	
}
