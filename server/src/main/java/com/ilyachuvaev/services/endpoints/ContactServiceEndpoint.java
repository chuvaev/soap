package com.ilyachuvaev.services.endpoints;

import com.ilyachuvaev.services.ContactService;

import com.ilyachuvaev.webservices.Contact;
import com.ilyachuvaev.webservices.contactservice.ContactDetailsRequest;
import com.ilyachuvaev.webservices.contactservice.ContactDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
@Controller
public class ContactServiceEndpoint {

    private static final String TARGET_NAMESPACE = "http://com/ilyachuvaev/webservices/contactservice";

    private ContactService contactService;

    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @PayloadRoot(localPart = "ContactDetailsRequest", namespace = TARGET_NAMESPACE)
    @RequestMapping(value = "/contact/{contactId}", method = RequestMethod.GET)
    public @ResponsePayload
    ContactDetailsResponse getContactDetails(@RequestPayload ContactDetailsRequest request, @RequestParam Long contactId) {
        ContactDetailsResponse response = new ContactDetailsResponse();
        response.setContactDetails(contactService.getContactDetails(contactId));
        return response;
    }

    @PayloadRoot(localPart = "ContactDetailsRequest", namespace = TARGET_NAMESPACE)
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public long addContact(@RequestAttribute ContactDetailsRequest request) {
        Contact contact = request.getContactDetails();
                contactService.saveOrUpdate(contact);
        return contact.getId();
    }

    @PayloadRoot(localPart = "ContactDetailsRequest", namespace = TARGET_NAMESPACE)
    @RequestMapping(value = "/contact", method = RequestMethod.PUT)
    public long updateContact(@RequestAttribute ContactDetailsRequest request) {
        Contact contact = request.getContactDetails();
        contactService.saveOrUpdate(contact);
        return contact.getId();
    }

    @PayloadRoot(localPart = "ContactDetailsRequest", namespace = TARGET_NAMESPACE)
    @RequestMapping(value = "/contact/{contactId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public long deleteContact(@RequestAttribute ContactDetailsRequest request, @RequestParam Long contactId) {
        contactService.delete(contactId);
        return contactId;
    }

}