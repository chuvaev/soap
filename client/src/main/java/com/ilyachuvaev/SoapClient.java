package com.ilyachuvaev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class SoapClient {
    // http://localhost:8080/ws/contacts.wsdl

    private static final Logger LOGGER = LoggerFactory.getLogger(SoapClient.class);
    private WebServiceTemplate webServiceTemplate;

    @Autowired
    public void setWebServiceTemplate(WebServiceTemplate webServiceTemplate){
        this.webServiceTemplate = webServiceTemplate;
    }

    public ContactResponse getContactDetails(String firstName){
        ObjectFactory factory = new ObjectFactory();
        Contact contact = factory.createContact();
        contact.setFirstName(firstName);

        LOGGER.info("Client sending contact[firstName={}]", contact.getFirstName());
        ContactResponse response = (ContactResponse) webServiceTemplate.marshalSendAndReceive(contact);

        return response;
    }

    public PostResponse addContact(Contact contact){
        ObjectFactory factory = new ObjectFactory();
        Contact contact1 = factory.createContact();
        contact1.setId(contact.getId());
        contact1.setFirstName(contact.getFirstName());
        contact1.setLastName(contact.getLastName());
        contact1.setEmail(contact.getEmail());
        contact1.setPhone(contact.getPhone());

        LOGGER.info("Client adding contact[id={}]", contact1.getId());
        PostResponse postResponse = (PostResponse) webServiceTemplate.marshalSendAndReceive(contact1);
        return postResponse;
    }

}
