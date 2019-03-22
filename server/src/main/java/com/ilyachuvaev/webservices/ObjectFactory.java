package com.ilyachuvaev.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName CONTACT_QNAME = new QName("http://webservices.ilyachuvaev.com", "Contact");

    public ObjectFactory(){
    }

    public Contact createContact(){return new Contact();}

    @XmlElementDecl(namespace = "http://webservices.ilyachuvaev.com", name = "Contact")
    public JAXBElement<Contact> createContact(Contact value){
        return new JAXBElement<Contact>(CONTACT_QNAME, Contact.class, null, value);
    }
}
