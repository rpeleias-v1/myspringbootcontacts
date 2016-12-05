package com.rodrigopeleias.myspringcontacts.controller.admin;

import com.rodrigopeleias.myspringcontacts.domain.Address;
import com.rodrigopeleias.myspringcontacts.domain.Contact;
import com.rodrigopeleias.myspringcontacts.domain.UF;
import com.rodrigopeleias.myspringcontacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AdminContactController {

    private ContactService contactService;

    @Autowired
    public AdminContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "/admin/contacts", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        return "admin/contacts/list";
    }

    @RequestMapping(value = "/admin/contacts/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("contact", contactService.findOne(id));
        return "admin/contacts/view";
    }

    @RequestMapping(value = "/admin/contacts/create")
    public String create(Model model) {
        Address address = new Address();
        Contact contact = new Contact();
        contact.setAddress(address);
        model.addAttribute("contact", contact);
        model.addAttribute("ufs", UF.values());
        return "admin/contacts/contactForm";
    }

    @RequestMapping(value = "/admin/contact/save", method = RequestMethod.POST)
    public String save(@Valid Contact contact, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ufs", UF.values());
            return "admin/contacts/create";
        } else {
            Contact savedContact = contactService.save(contact);
            return "redirect:/admin/contact/" + savedContact.getId();
        }
    }

    @RequestMapping(value = "/admin/contacts/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("contact", contactService.findOne(id));
        model.addAttribute("ufs", UF.values());
        return "admin/contacts/contactForm";
    }

    @RequestMapping(value = "/admin/contacts/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        contactService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Contact was deleted");
        return "redirect:/admin/contacts";
    }

}
