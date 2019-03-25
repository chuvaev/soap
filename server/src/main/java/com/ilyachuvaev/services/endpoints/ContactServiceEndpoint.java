package com.ilyachuvaev.services.endpoints;

import com.ilyachuvaev.services.ContactServiceImpl;
import com.ilyachuvaev.webservices.ContactDetailsRequest;
import com.ilyachuvaev.webservices.ContactDetailsResponse;
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

    @PayloadRoot(localPart = "ContactDetailsRequest", namespace = TARGET_NAMESPACE)
    @ResponsePayload
    public ContactDetailsResponse getContactDetails(@RequestPayload ContactDetailsRequest request) {
        ContactDetailsResponse response = new ContactDetailsResponse();
        response.setContactDetails(contactService.getContactDetails(request.getId()));
        return response;
    }

//    @PayloadRoot(localPart = "ContactDetailsRequest", namespace = TARGET_NAMESPACE)
//    @RequestMapping(value = "/contact", method = RequestMethod.POST)
//    public long addContact(@RequestAttribute ContactDetailsRequest request) {
//        Contact contact = request.getContactDetails();
//                contactService.saveOrUpdate(contact);
//        return contact.getId();
//    }
//
//    @PayloadRoot(localPart = "ContactDetailsRequest", namespace = TARGET_NAMESPACE)
//    @RequestMapping(value = "/contact", method = RequestMethod.PUT)
//    public long updateContact(@RequestAttribute ContactDetailsRequest request) {
//        Contact contact = request.getContactDetails();
//        contactService.saveOrUpdate(contact);
//        return contact.getId();
//    }
//
//    @PayloadRoot(localPart = "ContactDetailsRequest", namespace = TARGET_NAMESPACE)
//    @RequestMapping(value = "/contact/{contactId}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public long deleteContact(@RequestAttribute ContactDetailsRequest request, @RequestParam Long contactId) {
//        contactService.delete(contactId);
//        return contactId;
//    }

}