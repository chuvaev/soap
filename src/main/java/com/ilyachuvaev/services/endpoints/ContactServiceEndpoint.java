package com.ilyachuvaev.services.endpoints;

import com.ilyachuvaev.services.ContactService;

import com.ilyachuvaev.webservices.contactservice.ContactDetailsRequest;
import com.ilyachuvaev.webservices.contactservice.ContactDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping(value = "/")
    public @ResponsePayload
    ContactDetailsResponse getContactDetails(@RequestPayload ContactDetailsRequest request) {
        ContactDetailsResponse response = new ContactDetailsResponse();
        response.setContactDetails(contactService.getContactDetails(request.getId()));
        return response;
    }

    @PayloadRoot(localPart = "ContactDetailsRequest", namespace = TARGET_NAMESPACE)
    public long addContact(@RequestAttribute ContactDetailsRequest request) {
        ContactDetailsResponse response = new ContactDetailsResponse();

        return response;
    }

    @PayloadRoot(localPart = "ContactDetailsRequest", namespace = TARGET_NAMESPACE)
    public long updataContact(@RequestAttribute ContactDetailsRequest request) {
        ContactDetailsResponse response = new ContactDetailsResponse();

        return response;
    }

    @PayloadRoot(localPart = "ContactDetailsRequest", namespace = TARGET_NAMESPACE)
    public long deleteContact(@RequestAttribute ContactDetailsRequest request) {
        ContactDetailsResponse response = new ContactDetailsResponse();

        return response;
    }
}