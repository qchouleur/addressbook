package fr.esiea.addressbook.models;

import org.hibernate.validator.constraints.NotEmpty;

public class Address {
	
	private Id id;
	
	@NotEmpty
	private String alias;
	
	@NotEmpty
	private String number;
	
	@NotEmpty
	private String street;
	
	@NotEmpty
	private String zipcode;
	
	@NotEmpty
	private String city;
	
	public Address(){}
	
	public Address(String alias, String number, String street, String zipcode, String city)
	{
		this.id = Id.generate();
		
		this.alias = alias;
		this.number = number;
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
	}
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Id getId() {
		return this.id;
	}
	public void setId(Id id) {
		this.id = id;
	}
}
