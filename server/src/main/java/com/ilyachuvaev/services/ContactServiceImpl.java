package com.ilyachuvaev.services;

import com.ilyachuvaev.exception.ContactNotFoundException;
import com.ilyachuvaev.repository.ContactRepository;
import com.ilyachuvaev.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.jws.WebService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@WebService(serviceName = "ContactService", portName = "ContactServicePort", targetNamespace = "http://webservices.ilyachuvaev.com")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class ContactServiceImpl implements ContactService{

    private ContactRepository contactRepository;
    private final int size = 20;
    private final String fileName = "C:/contacts.xml";

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
        ArrayList<Contact> contacts = new ArrayList<>(size);
        contacts.addAll(getAllContacts());
        return contacts;
    }

    public List<Contact> getAllContacts(){return (List<Contact>) contactRepository.findAll();}

    public Contact fromXmlToObject(String filePath){
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Contact.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Contact) unmarshaller.unmarshal(new File(filePath));
        }catch (JAXBException e){
            e.printStackTrace();
        }
        return null;
    }

    public void convertObjectToXml(Contact contact, String filePath){
        try{
            JAXBContext context = JAXBContext.newInstance(Contact.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(contact,new File(filePath));
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }

}
