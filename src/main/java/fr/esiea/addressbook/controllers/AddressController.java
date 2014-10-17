package fr.esiea.addressbook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.esiea.addressbook.data.StaticContactDataStorage;
import fr.esiea.addressbook.models.Address;
import fr.esiea.addressbook.models.Contact;
import fr.esiea.addressbook.models.Id;
import fr.esiea.addressbook.services.ContactService;
import fr.esiea.addressbook.specifications.NameContainsKeywordSpecification;


@Controller
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private MessageSource messageSource;
	private ContactService service = StaticContactDataStorage.service();
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Mandatory, otherwise the contact model validation keep 
		// failing because of string to Id conversion
		binder.setDisallowedFields("id");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(
			@RequestParam(value = "q", required = false) String query,
			@RequestParam(value = "id", required = false) String id,
			RedirectAttributes redirectAttributes,
			ModelMap model) {

		
		Id contactId = Id.fromString(id);
		
		if(!service.exists(contactId)) {
			redirectAttributes.addFlashAttribute("error",messageSource.getMessage("Invalid.contact.id", null, null));
			return new ModelAndView("address/list");
		}
		
		Contact contact = service.getById(contactId);
		
		List<Address> results = contact.getAddressQuery(query);
		model.addAttribute("address", results);
				
		if(results.isEmpty()) {
			model.addAttribute("error", messageSource.getMessage("Empty.address.list", null, null));
		}
		
		ModelAndView newModel = new ModelAndView("address/list", "addresses", results);
		newModel.addObject("contactId",contactId);
		
		return newModel;

	}
	
	
	@RequestMapping(value = {"/{contactId}", "/list/{contactId}"}, method = RequestMethod.GET)
	public ModelAndView list(@PathVariable(value = "contactId") String id, 
			ModelMap model, 
			RedirectAttributes redirectAttributes) {
		
		Id contactId = Id.fromString(id);
		
		if(!service.exists(contactId)) {
			redirectAttributes.addFlashAttribute("error",messageSource.getMessage("Invalid.contact.id", null, null));
			return ContactController.HOME_REDIRECTION;
		}
		
		model.addAttribute("contactId", id);
		Contact contact = service.getById(contactId);
		if(contact.getAdresses().isEmpty()) {
			model.addAttribute("error", messageSource.getMessage("Empty.address.list", null, null));
		}
		
		return new ModelAndView("address/list", "addresses", contact.getAdresses());
		
	}
	
	@RequestMapping(value = "create/{contactId}", method = RequestMethod.GET)
	public ModelAndView create(@PathVariable(value = "contactId") String id, ModelMap model) {
		
		model.addAttribute("contactId", id);
		
		return new ModelAndView("address/create", "address", new Address());
	}
	
	@RequestMapping(value = "/create/{contactId}", method = RequestMethod.POST)
	public ModelAndView create(
			@PathVariable(value = "contactId") String id,
			@ModelAttribute("address") @Valid Address address,
			BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			model.addAttribute("contactId", id);
			return new ModelAndView("address/create");
		}

		Id idContact = Id.fromString(id);
		address.setId(Id.generate());
		Contact contact = service.getById(idContact);
		
		boolean res = contact.checkBillsAddressAlreadyExist(address);
		
		if(res)
		{
			redirectAttributes.addFlashAttribute("error",messageSource.getMessage("Invalid.address.facturation", null, null));
			return new ModelAndView(
					"redirect:/address/"+idContact);
		}
		else
		{
			contact.addAddress(address);
		}
		
		return new ModelAndView(
				"redirect:/address/"+idContact);
	}
	
	
	@RequestMapping(value = "/edit/{contactId}/{addressId}", method = RequestMethod.GET)
	public ModelAndView edit(
			@PathVariable(value = "contactId") String cId,
			@PathVariable(value = "addressId") String aId) {

		Id idContact = Id.fromString(cId);
		Contact contact = service.getById(idContact);
		Address address = contact.getAddressById(Id.fromString(aId));

		ModelAndView model = new ModelAndView("address/edit", "address", address);
		model.addObject("contactId", idContact);
		
		return address != null ?  model : new ModelAndView("redirect:/address/"+idContact);
	}

	@RequestMapping(value = "/edit/{contactId}/{addressId}", method = RequestMethod.POST)
	public ModelAndView edit(
			@PathVariable(value = "contactId") String cId,
			@PathVariable(value = "addressId") String aId,
			@ModelAttribute("address") @Valid Address address,
			BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			return new ModelAndView("address/edit");
		}
		
		Id contactId = Id.fromString(cId);
		Id addressId = Id.fromString(aId);
		
		if (!service.exists(contactId)) {
			redirectAttributes.addFlashAttribute("error",messageSource.getMessage("Invalid.contact.id", null, null));
			return ContactController.HOME_REDIRECTION;
		}
		
		
		Contact contact = service.getById(contactId);
		contact.deleteAddressById(addressId);
		address.setId(addressId);
		contact.addAddress(address);
		
		return new ModelAndView(
				"redirect:/address/"+contactId);
	}
	
	@RequestMapping(value = "/delete/{contactId}/{addressId}", method = RequestMethod.POST)
	public ModelAndView delete(
			@PathVariable(value = "contactId") String cId,
			@PathVariable(value = "addressId") String aId,
			RedirectAttributes redirectAttributes) {
		
		Id contactId = Id.fromString(cId);
		Id addressId = Id.fromString(aId);
		
		if (!service.exists(contactId)) {
			redirectAttributes.addFlashAttribute("error",messageSource.getMessage("Invalid.contact.id", null, null));
			return ContactController.HOME_REDIRECTION;
		}
		
		Contact contact = service.getById(contactId);
		contact.deleteAddressById(addressId);
		
		return new ModelAndView(
				"redirect:/address/"+contactId);
	}
}
