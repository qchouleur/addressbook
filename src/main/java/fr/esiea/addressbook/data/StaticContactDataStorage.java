package fr.esiea.addressbook.data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import fr.esiea.addressbook.models.Contact;
import fr.esiea.addressbook.models.Id;
import fr.esiea.addressbook.repositories.InMemoryContactRepository;
import fr.esiea.addressbook.services.ContactRepository;
import fr.esiea.addressbook.services.ContactService;

public class StaticContactDataStorage {

	private static StaticContactDataStorage instance;
	private final ContactService service;
	
	private StaticContactDataStorage() {
		Map<Id, Contact> datasource = new HashMap<Id, Contact>();

		Contact bob = new Contact("Aventure", "Georges", "georges@google.com", new Date());
		datasource.put(bob.getId(), bob);
		bob = new Contact("Franche", "Victoire", "victoire@sfr.com", new Date());
		datasource.put(bob.getId(), bob);
		bob = new Contact("Bienvenue", "Paul", "bienvenue@sfr.com", new Date());
		datasource.put(bob.getId(), bob);
		bob = new Contact("Toure", "Yaya", "toure@rhyta.com", new Date());
		datasource.put(bob.getId(), bob);
		bob = new Contact("Hazard", "Eden", "hazard@rhyta.com", new Date());
		datasource.put(bob.getId(), bob);
		bob = new Contact("Zidane", "Zinedine", "zidane@rhyta.com", new Date());
		datasource.put(bob.getId(), bob);
		bob = new Contact("Ronaldo", "Cristiano", "ronaldo@rhyta.com", new Date());

		datasource.put(bob.getId(), bob);

		ContactRepository repository = new InMemoryContactRepository(datasource);
		this.service = new ContactService(repository);
	}
	
	public static ContactService service() {
		if(instance == null) {
			instance = new StaticContactDataStorage();
		}
		
		return instance.service;
	}

	
}
