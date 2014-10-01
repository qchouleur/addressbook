package fr.esiea.addressbook.services;

import java.util.List;

import fr.esiea.addressbook.models.Contact;
import fr.esiea.addressbook.models.Id;

public class ContactService {
	
	private ContactRepository repository;
	
	public ContactService(ContactRepository repository) {
		this.repository = repository;
	}
	
	public void create(Contact contact) {
		repository.save(contact);
	}
	
	public void update(Contact contact) {
		repository.save(contact);
	}
	
	public void remove(Id id) {
		repository.remove(id);
	}
	
	public boolean exists(Id id) {
		return repository.get(id) != null;
		
	}
	
	public Contact getById(Id id) {
		return repository.get(id);
	}
	
	public List<Contact> find(ContactSpecification specification) {
		return repository.find(specification);
	}
	
	public List<Contact> all() {
		return repository.all();
	}
	
}
