package fr.esiea.addressbook.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.esiea.addressbook.models.Contact;
import fr.esiea.addressbook.models.Id;
import fr.esiea.addressbook.services.ContactRepository;
import fr.esiea.addressbook.services.ContactSpecification;

public class InMemoryContactRepository implements ContactRepository {

	private Map<Id, Contact> datasource;
	
	public InMemoryContactRepository() {
		this.datasource = new HashMap<Id, Contact>();
	}
	
	public InMemoryContactRepository(Map<Id, Contact> datasource) {
		if(datasource == null) {
			throw new IllegalArgumentException("The datasource cannot be null.");
		}
		
		this.datasource = datasource;
	}
	
	public void save(Contact contact) {
		if(!datasource.containsKey(contact.getId())) {
			datasource.put(contact.getId(), contact);
		} else {
			datasource.get(contact.getId()).updateWith(contact);
		}
	}

	public void remove(Id id) {
		if(datasource.containsKey(id)) {
			datasource.remove(id);
		}
	}

	public Contact get(Id contactId) {
		return this.datasource.get(contactId);
	}

	public List<Contact> find(ContactSpecification specification) {
		
		List<Contact> results = new ArrayList<Contact>();
		
		for(Contact contact : this.all()) {
			if(specification.isSatisfiedBy(contact)) {
				results.add(contact);
			}
		}

		return results;
	}
	
	public List<Contact> all() {
		
		return new ArrayList<Contact>(this.datasource.values());
	}

}
