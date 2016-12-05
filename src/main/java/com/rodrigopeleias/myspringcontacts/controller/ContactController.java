package com.rodrigopeleias.myspringcontacts.controller;

import com.rodrigopeleias.myspringcontacts.repository.AddressRepository;
import com.rodrigopeleias.myspringcontacts.repository.ContactRepository;
import com.rodrigopeleias.myspringcontacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        return "contacts/list";
    }
}
