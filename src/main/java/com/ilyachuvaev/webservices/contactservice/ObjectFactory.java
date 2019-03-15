package com.ilyachuvaev.webservices.contactservice;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory(){
    }

    public ContactDetailsRequest createContactDetailsRequest(){return new ContactDetailsRequest();}

    public ContactDetailsResponse createContactDetailsResponse(){return new ContactDetailsResponse();}
}
