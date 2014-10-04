package fr.esiea.addressbook.specifications;

import fr.esiea.addressbook.models.Contact;
import fr.esiea.addressbook.services.ContactSpecification;

public class ActiveSpecification implements ContactSpecification {

	@Override
	public boolean isSatisfiedBy(Contact contact) {
		
		return contact.isActive();
	}

	
}
