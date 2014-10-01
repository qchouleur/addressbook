package fr.esiea.addressbook.services;

import fr.esiea.addressbook.models.Contact;

public interface ContactSpecification {

	boolean isSatisfiedBy(Contact contact);
	
}
