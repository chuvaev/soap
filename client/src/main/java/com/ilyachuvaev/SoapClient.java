package com.ilyachuvaev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
public class SoapClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(SoapClient.class);
    private WebServiceTemplate webServiceTemplate;
    private final String fileName = "C:/contacts.xml";

    @Autowired
    public void setWebServiceTemplate(WebServiceTemplate webServiceTemplate){
        this.webServiceTemplate = webServiceTemplate;
    }

    public Contact getContactDetails(String firstName){
        ObjectFactory factory = new ObjectFactory();
        Contact contact = factory.createContact();
        contact.setFirstName(firstName);

        LOGGER.info("Client sending contact[firstName={}, lastName={}]", contact.getFirstName(), contact.getLastName());

        return contact;
    }

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
