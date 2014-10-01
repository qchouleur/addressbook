package fr.esiea.addressbook.specifications;

import fr.esiea.addressbook.models.Contact;
import fr.esiea.addressbook.services.ContactSpecification;

public class NameContainsKeywordSpecification implements ContactSpecification {

	private String keyword;
	
	public NameContainsKeywordSpecification(String keyword) {
		if(keyword == null || keyword.isEmpty()) {
			throw new IllegalArgumentException("The keyword must have a value");
		}
		
		this.keyword = keyword.toLowerCase();
	}
	
	public boolean isSatisfiedBy(Contact contact) {
		
		return contact.getFirstName().toLowerCase().contains(keyword) 
				|| contact.getLastName().toLowerCase().contains(keyword);
	}

}
