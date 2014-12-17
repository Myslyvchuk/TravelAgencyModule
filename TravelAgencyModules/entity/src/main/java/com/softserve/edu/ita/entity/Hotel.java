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
	private City city;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.PERSIST)
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
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Set<Booking> getBooking() {
		return booking;
	}
	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (booking == null) {
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
		
	
}
