package com.ilyachuvaev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class SoapClient {
    // http://localhost:8080/ws/contacts.wsdl
    // http://programming-lang.com/ru/comp_programming/troelsen/0/j2166.html

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

}
