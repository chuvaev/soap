package com.ilyachuvaev.services;

import com.ilyachuvaev.Contact;
import com.ilyachuvaev.exception.ContactNotFoundException;
import com.ilyachuvaev.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.WebService;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@WebService(serviceName = "ContactService", portName = "ContactServicePort", targetNamespace = "http://soapservice.ilyachuvaev.com")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class ContactServiceImpl implements ContactService{

    private ContactRepository contactRepository;
    private int size = 2;

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @WebMethod
    public Contact getContactDetails(Long id){
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.orElseThrow(() -> new ContactNotFoundException("Contact with id = " + id + " not found)"));

    }

    @WebMethod
    public long saveOrUpdate(Contact contact){
        if (contact != null){
            contactRepository.save(contact);
        }else {
            throw new ContactNotFoundException("Contact not found)");
        }
        return contact.getId();
    }

    @WebMethod
    public long  delete(Long id){
        Optional<Contact> contact = contactRepository.findById(id);
        contact.ifPresentOrElse(
                v -> contactRepository.deleteById(id),
                () -> new ContactNotFoundException("Contact with id = " + id + " not found")
        );
        return id;
    }

    @WebMethod
    public List<Contact> getContacts(){
        List<Contact> contacts = getAllContacts();
        LinkedList<Contact> contactsList = new LinkedList<>();
        Iterator<Contact> iterator = contacts.iterator();
        int point = 0;
        while (iterator.hasNext() && point <= size){
            Contact i = iterator.next();
            contacts.add(i);
            point++;
        }
        return contactsList;
    }

    public List<Contact> getAllContacts(){return (List<Contact>) contactRepository.findAll();}



}
