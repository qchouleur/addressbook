package fr.esiea.addressbook.services;

import java.util.List;

import fr.esiea.addressbook.models.Contact;
import fr.esiea.addressbook.models.Id;

public interface ContactRepository {

	void save(Contact contact);
	void remove(Id id);
	Contact get(Id id);
	
	List<Contact> find(ContactSpecification specification);
	List<Contact> all();
	
}
