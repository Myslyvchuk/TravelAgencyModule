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
	private String surname;
	@Column(name = "age", length = 32)
	private int age;
	@OneToMany(mappedBy = "clientID", cascade = CascadeType.PERSIST)
	private Set<Visa> visa;
	@OneToMany(mappedBy = "clientID", cascade = CascadeType.PERSIST)
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	

}
