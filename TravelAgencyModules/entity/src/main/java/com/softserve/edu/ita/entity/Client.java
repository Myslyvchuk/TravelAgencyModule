package com.softserve.edu.ita.entity;


import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "name", length = 32)
	private String name;
	
	@Column(name = "surname", length = 32)
	private String lastname;
	
	@Column(name = "age", length = 32)
	private int age;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
	private Set<Visa> visa;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
	private Set<Booking> booking;
	
	public Client() {
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

	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Visa> getVisa() {
		return visa;
	}

	public void setVisa(Set<Visa> visa) {
		this.visa = visa;
	}

	public Set<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((visa == null) ? 0 : visa.hashCode());
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
		Client other = (Client) obj;
		if (age != other.age)
			return false;
		if (booking == null) {
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
		if (id != other.id)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (visa == null) {
			if (other.visa != null)
				return false;
		} else if (!visa.equals(other.visa))
			return false;
		return true;
	}

	

}
