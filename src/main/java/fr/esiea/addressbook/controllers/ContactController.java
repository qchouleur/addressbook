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
import fr.esiea.addressbook.models.Contact;
import fr.esiea.addressbook.models.Id;
import fr.esiea.addressbook.services.ContactService;
import fr.esiea.addressbook.specifications.NameContainsKeywordSpecification;

@Controller
@RequestMapping(value = {"/", "/contact"})
public class ContactController {

	public static final ModelAndView HOME_REDIRECTION = new ModelAndView(
			"redirect:/");

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
	public String index(
			@RequestParam(value = "q", required = false) String query,
			ModelMap model) {

		List<Contact> results =  (query == null || query.isEmpty()) ? 
				service.all() : service.find(new NameContainsKeywordSpecification(query));
		model.addAttribute("contacts", results);
				
		if(results.isEmpty()) {
			model.addAttribute("error", messageSource.getMessage("Empty.contact.list", null, null));
		}
		
		return "index";

	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("contact/create", "contact", new Contact());
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(
			@ModelAttribute("contact") @Valid Contact contact,
			BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return new ModelAndView("contact/create");
		}
		
		contact.setId(Id.generate());
		service.create(contact);
		return HOME_REDIRECTION;

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(
			@PathVariable(value = "id") String id,
			RedirectAttributes redirectAttributes) {

		Id contactId = Id.fromString(id);
		
		if(!service.exists(contactId)) {
			redirectAttributes.addFlashAttribute("error", messageSource.getMessage("Invalid.contact.id", null, null));
			return HOME_REDIRECTION;
		}
		
		Contact contact = service.getById(contactId);
		return new ModelAndView("contact/edit", "contact", contact);
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST, params="!id")
	public ModelAndView edit(
			@PathVariable(value = "id") String id,
			@ModelAttribute("contact") @Valid Contact contact,
			BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			return new ModelAndView("contact/edit");
		}
		
		Id contactId = Id.fromString(id);
		if(!service.exists(contactId)) {
			redirectAttributes.addFlashAttribute("error", messageSource.getMessage("Invalid.contact.id", null, null));
			return HOME_REDIRECTION;
		}
		
		contact.setId(contactId);
		service.update(contact);
		
		return HOME_REDIRECTION;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable(value = "id") String id,
			RedirectAttributes redirectAttributes) {
		
		Id contactId = Id.fromString(id);
		
		if(!service.exists(contactId)) {
			redirectAttributes.addFlashAttribute("error",messageSource.getMessage("Invalid.contact.id", null, null));
			return HOME_REDIRECTION;
		}
		
		service.remove(contactId);
		
		return HOME_REDIRECTION;
	}
}
