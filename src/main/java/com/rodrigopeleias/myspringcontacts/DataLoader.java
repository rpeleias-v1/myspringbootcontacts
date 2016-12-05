package com.rodrigopeleias.myspringcontacts;

import com.rodrigopeleias.myspringcontacts.domain.Address;
import com.rodrigopeleias.myspringcontacts.domain.Contact;
import com.rodrigopeleias.myspringcontacts.domain.UF;
import com.rodrigopeleias.myspringcontacts.repository.AddressRepository;
import com.rodrigopeleias.myspringcontacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataLoader {

    private AddressRepository addressRepository;
    private ContactRepository contactRepository;

    @Autowired
    public DataLoader(AddressRepository addressRepository, ContactRepository contactRepository) {
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
    }

    @PostConstruct
    private void insertData() {
        Address rodrigoHouse = new Address();
        rodrigoHouse.setName("Rua Tibiri");
        rodrigoHouse.setNumber("282");
        rodrigoHouse.setComplement("apto. 122");
        rodrigoHouse.setCity("São Paulo");
        rodrigoHouse.setUf(UF.SP);
        rodrigoHouse.setZipCode("02043-070");
        rodrigoHouse.setNeighborhood("Jardim São Paulo");

        Contact contact = new Contact();
        contact.setName("Rodrigo Peleias");
        contact.setEmail("rpeleias@hotmail.com");
        contact.setHomePhone("(+5511)2679-2589");
        contact.setMobilePhone("(+5511)99995-1599");
        contact.setAddress(rodrigoHouse);

        contactRepository.save(contact);
    }
}
