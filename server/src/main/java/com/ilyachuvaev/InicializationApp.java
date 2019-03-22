package com.ilyachuvaev;

import com.ilyachuvaev.repository.ContactRepository;
import com.ilyachuvaev.webservices.Contact;
import org.springframework.beans.factory.annotation.Autowired;

public class InicializationApp {

    private ContactRepository contactRepository;

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    void init(){
        contactRepository.save(new Contact(1L, "Jaon", "Jonson", "+74951512365", "jony@jon.com"));
        contactRepository.save(new Contact(2L, "Sally", "Sally", "+74955693522", "saly@saly.com"));
        contactRepository.save(new Contact(1L, "Tony", "Tony", "+74951512345", "tony@tony.com"));
        contactRepository.save(new Contact(1L, "Bob", "Bob", "+74987845414", "bob@bob.com"));
        contactRepository.save(new Contact(2L, "Ruby", "Ruby", "+74956546566", "ruby@ruby.com"));
        contactRepository.save(new Contact(1L, "Max", "Max", "+74954567891", "max@max.com"));

    }

    public InicializationApp(){}
}
