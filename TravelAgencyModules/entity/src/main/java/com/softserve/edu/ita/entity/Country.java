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
	
	@OneToMany(mappedBy = "country", cascade = CascadeType.PERSIST)
	private Set<City> city;
	
	@OneToMany(mappedBy = "country", cascade = CascadeType.PERSIST)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + id;
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
		Country other = (Country) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id != other.id)
			return false;
		if (visa == null) {
			if (other.visa != null)
				return false;
		} else if (!visa.equals(other.visa))
			return false;
		return true;
	}

}
