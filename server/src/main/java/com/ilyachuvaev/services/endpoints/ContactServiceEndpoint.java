package com.ilyachuvaev.services.endpoints;

import com.ilyachuvaev.Contact;
import com.ilyachuvaev.ContactRequest;
import com.ilyachuvaev.ContactResponse;
import com.ilyachuvaev.ObjectFactory;
import com.ilyachuvaev.services.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class ContactServiceEndpoint {

    private static final String TARGET_NAMESPACE = "http://ilyachuvaev.com/services/soapservice";

    private ContactServiceImpl contactService;

    @Autowired
    public void setContactService(ContactServiceImpl contactService) {
        this.contactService = contactService;
    }

    @PayloadRoot(localPart = "ContactRequest", namespace = TARGET_NAMESPACE)
    @ResponsePayload
    public ContactResponse getContactDetails(@RequestPayload ContactRequest request) {
        ContactResponse response = new ContactResponse();
        Contact contact = request.getContact();
        response.setContact(contactService.getContactDetails(contact.getId()));
        return response;
    }

    @PayloadRoot(localPart = "ContactsRequest", namespace = TARGET_NAMESPACE)
    @ResponsePayload
    public long addContact(@RequestPayload ContactRequest request) {
        ObjectFactory factory = new ObjectFactory();
        Contact contact = factory.createContact();
        contactService.saveOrUpdate(contact);
        return contact.getId();
    }

    @PayloadRoot(localPart = "ContactsRequest", namespace = TARGET_NAMESPACE)
    @ResponsePayload
    public ContactResponse updateContact(@RequestPayload ContactRequest request) {
        Contact contact = request.getContact();
        ContactResponse response = new ContactResponse();
        contactService.saveOrUpdate(contact);
        response.setContact(contact);
        return response;
    }

    @PayloadRoot(localPart = "ContactRequest", namespace = TARGET_NAMESPACE)
    public void deleteContact(@RequestPayload ContactRequest request) {
        Contact contact = request.getContact();
        contactService.delete(contact.getId());
    }

}