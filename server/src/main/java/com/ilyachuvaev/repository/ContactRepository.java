package com.ilyachuvaev.repository;

import com.ilyachuvaev.Contact;
import com.ilyachuvaev.exception.ContactNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContactRepository {

    private List<Contact> contactRepository = new ArrayList<>();

    public Contact save(Contact contact){
        contactRepository.add(contact);
        return contact;
    }

    public Optional<Contact> findById(Long id){
        List<Contact> contacts = findAll();
        Contact contact = new Contact();
        for (int i = 0; i < contacts.size(); i++)
            if (i == id) {
                contact = contacts.get(i);
            } else throw new ContactNotFoundException("Contact with id = " + id + " not found)");
        return Optional.of(contact);
    }

    public List<Contact> findAll(){
        List<Contact> contacts = contactRepository.subList(0,contactRepository.size());
        return contacts;
    }

    public void deleteById(Long id){

    }

}
