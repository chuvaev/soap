package com.ilyachuvaev.services;

import com.ilyachuvaev.entity.ContactMapper;
import com.ilyachuvaev.exception.ContactNotFoundException;
import com.ilyachuvaev.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.WebService;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@WebService(serviceName = "ContactService", portName = "Contacts", targetNamespace = "http://localhost:8080/soapservice/ws")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class ContactServiceImpl implements ContactService {

  private final ContactRepository contactRepository;
  private int size = 2;

  @WebMethod
  public ContactMapper getContact(Long id) {
    Optional<ContactMapper> contact = contactRepository.findById(id);
    return contact.orElseThrow(() -> new ContactNotFoundException("Contact with id = " + id + " not found)"));

  }

  @WebMethod
  public long saveOrUpdate(ContactMapper contact) {
    if (contact != null) {
      contactRepository.save(contact);
    } else {
      throw new ContactNotFoundException("Contact not found)");
    }
    return contact.getId();
  }

  @WebMethod
  public long delete(Long id) {
    Optional<ContactMapper> contact = contactRepository.findById(id);
    if (contact.isPresent()) {
      contactRepository.deleteById(id);
    } else {
      throw new ContactNotFoundException("Contact with id = " + id + " not found");
    }
    return id;
  }

  @WebMethod
  public List<ContactMapper> getContacts() {
    List<ContactMapper> contacts = getAllContacts();
    LinkedList<ContactMapper> contactsList = new LinkedList<>();
    Iterator<ContactMapper> iterator = contacts.iterator();
    int point = 0;
    while (iterator.hasNext() && point <= size) {
      ContactMapper i = iterator.next();
      contacts.add(i);
      point++;
    }
    return contactsList;
  }

  public List<ContactMapper> getAllContacts() {
    return (List<ContactMapper>) contactRepository.findAll();
  }


}
