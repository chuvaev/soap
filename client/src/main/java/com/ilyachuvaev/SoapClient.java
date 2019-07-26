package com.ilyachuvaev;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.bind.JAXBElement;

@Component
@AllArgsConstructor
public class SoapClient {
//     http://localhost:8080/soapservice/ws/contacts.wsdl

  private static final Logger LOGGER = LoggerFactory.getLogger(SoapClient.class);

  private final WebServiceTemplate webServiceTemplate;

  public Contact getContact(Long id) {
    ContactRequest contactRequest = new ObjectFactory().createContactRequest();
    Contact contact = contactRequest.getContact();
    contact.setId(id);
    LOGGER.info("Client sending Contact[id={}]", contactRequest.getContact().getId());
    JAXBElement<Contact> responseContact = (JAXBElement<Contact>) webServiceTemplate
        .marshalSendAndReceive(contactRequest);
    LOGGER.info("Client received Contact[id={}]", responseContact.getValue().getId());
    return responseContact.getValue();
  }

  public Long addContact(ContactRequest request) {
    ContactRequest contactRequest = new ObjectFactory().createContactRequest();
    contactRequest.setContact(request.getContact());

    LOGGER.info("Client adding Contact[id={}]", contactRequest.getContact().getId());
    JAXBElement<Contact> responseContact = (JAXBElement<Contact>) webServiceTemplate
        .marshalSendAndReceive(contactRequest);
    LOGGER.info("Client received Contact[id={}]", responseContact.getValue().getId());
    return responseContact.getValue().getId();
  }

}
