package com.softserve.edu.ita.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "country", length = 32)
	private String country;
	@OneToMany(mappedBy = "countryID", cascade = CascadeType.PERSIST)
	private Set<City> city;
	@OneToMany(mappedBy = "countryID", cascade = CascadeType.PERSIST)
	private Set<Visa> visa;

	public Country() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<City> getCity() {
		return city;
	}

	public void setCity(Set<City> city) {
		this.city = city;
	}

	public Set<Visa> getVisa() {
		return visa;
	}

	public void setVisa(Set<Visa> visa) {
		this.visa = visa;
	}

}
