package com.rodrigopeleias.myspringcontacts.service;

import com.rodrigopeleias.myspringcontacts.domain.Contact;
import com.rodrigopeleias.myspringcontacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact findOne(Long id) {
        return contactRepository.findOne(id);
    }

    public Iterable<Contact> findAll() {
        return contactRepository.findAllByOrderByNameDesc();
    }

    public void delete(Long id) {
        contactRepository.delete(id);
    }
}
