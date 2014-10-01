package fr.esiea.addressbook.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.addressbook.models.Contact;
import fr.esiea.addressbook.models.Id;
import fr.esiea.addressbook.repositories.InMemoryContactRepository;
import fr.esiea.addressbook.services.ContactRepository;
import fr.esiea.addressbook.services.ContactSpecification;
import fr.esiea.addressbook.specifications.NameContainsKeywordSpecification;


public class InMemoryContactRepositoryTest {

	private ContactRepository repository;
	
	@Before
	public void setUp() {
		HashMap<Id, Contact> datasource = new HashMap<Id, Contact>();
		
		Contact estelle = new Contact("Gagne", "Estelle", "estellegagn@rhyta.com", new Date());
		Contact carol = new Contact("Gentry", "Carol", "carol.gentry@jourrapide.com", new Date());
		Contact lucille = new Contact("Kelley", "Lucille", "lucille.kelley@jourrapide.com", new Date());
		
		datasource.put(estelle.getId(), estelle);
		datasource.put(carol.getId(), carol);
		datasource.put(lucille.getId(), lucille);
		
		this.repository = new InMemoryContactRepository(datasource);
	}
	
	@Test
	public void SearchByKeyworkdShouldReturnResults() {
		
		ContactSpecification specification = new NameContainsKeywordSpecification("lle");
		
		List<Contact> results = this.repository.find(specification);
		
		Assert.assertNotNull("result list must no be null", results);
		Assert.assertEquals(results.size(), 2);
	}
	
	@Test
	public void ContactCreationShouldSucceed() {
		
		Contact lucille = new Contact("Kelley", "Lucille", "lucille.kelley@jourrapide.com", new Date());
		
		this.repository.save(lucille);
		Contact inserted = this.repository.get(lucille.getId());
		
		Assert.assertNotNull("contact creation failed", inserted);
		Assert.assertEquals(lucille.getLastName(), inserted.getLastName());
		
	}
}
