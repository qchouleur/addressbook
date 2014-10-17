package fr.esiea.addressbook.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import fr.esiea.addressbook.controllers.ContactController;

public class Contact {
	
	
	private Id id;
	
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfBirth;
	
	private boolean active;
	
	private List<Address> addresses = new ArrayList<Address>();
	
	public Contact() {
	
		this.id = Id.generate();
		
		this.active = true;
		
	}
	
	public Contact(String name, String firstname, String email, Date dateOfBirth) {
		
		this.id = Id.generate();
		
		this.active = true;
		this.lastName = name;
		this.firstName = firstname;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String name) {
		this.lastName = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public List<Address> getAdresses() {
		if(addresses == null) {
			addresses = new ArrayList<Address>();
		}
		return addresses;
	}
	
	public void addAddress(Address adresse)
	{
		getAdresses().add(adresse);
	}
	
	public Id getId() {
		return this.id;
	}
	
	public void setId(Id id) {
		this.id = id;
	}

	public void updateWith(Contact contact) {
		this.lastName = contact.lastName;
		this.firstName = contact.firstName;
		this.email = contact.email;
		this.dateOfBirth = contact.dateOfBirth;
	}
	
	public List<Address> getAddresses() {
		return this.addresses;
	}
	
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public Address getAddressById(Id id)
	{
		for(Address address : this.addresses)
		{
			if(address.getId().equals(id))
				return address;
		}
		
		return null;
	}
	
	public void deleteAddressById(Id id)
	{
		Address addressToDel = null;
		for(Address address : this.addresses)
		{
			if(address.getId().equals(id))
				addressToDel = address;
		}
		
		if(addressToDel != null)
			this.addresses.remove(addressToDel);
	}
	
	public List<Address> getAddressQuery(String query)
	{
		List<Address> addressList = new ArrayList<Address>();
		
		for(Address address : this.addresses)
		{
			if(address.getAlias().contains(query))
					addressList.add(address);
		}
		
		return addressList;
	}
	
	public boolean checkBillsAddressAlreadyExist(Address address)
	{
		if(address.getAlias().equals("Facturation") && !this.getAdresses().isEmpty())
		{
			for(Address addr: this.getAdresses())
			{
				if(addr.getAlias().equals("Facturation"))
				{
					return true;
				}
			}
		}
		else
		{
			return false;
		}
		
		return false;
	}
}
