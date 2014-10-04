package fr.esiea.addressbook.specifications;


import fr.esiea.addressbook.models.Contact;
import fr.esiea.addressbook.services.ContactSpecification;

public class ComplexSpecification implements ContactSpecification {

	private final ContactSpecification[] specifications;
	
	public ComplexSpecification(ContactSpecification... specifications) {
		this.specifications = specifications;
	}

	@Override
	public boolean isSatisfiedBy(Contact contact) {
		
		for(ContactSpecification specification : specifications) {
			if(!specification.isSatisfiedBy(contact)) {
				return false;
			}
		}
		
		return true;
		
	}
	
	

}
