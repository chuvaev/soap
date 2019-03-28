package com.ilyachuvaev;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

public class WebServiceTemplate {

    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    private String defoultUri;

    public void setMarshaller(Jaxb2Marshaller marshaller){
        this.marshaller = marshaller;
    }

    public void setUnMarshaller(Jaxb2Marshaller unmarshaller){
        this.unmarshaller = unmarshaller;
    }

    public void setDefaultUri(String defaultUri){
        this.defoultUri = defaultUri;
    }
    public Contact fromXmlToObject(String filePath){
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Contact.class);
            javax.xml.bind.Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Contact) unmarshaller.unmarshal(new File(filePath));
        }catch (JAXBException e){
            e.printStackTrace();
        }
        return null;
    }

    public void convertObjectToXml(Contact contact, String filePath){
        try{
            JAXBContext context = JAXBContext.newInstance(Contact.class);
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(contact,new File(filePath));
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
