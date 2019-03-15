package com.ilyachuvaev.webservices.contactservice;

import com.ilyachuvaev.webservices.Contact;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ("contactDetails"))
@XmlRootElement(name = "ContactDetailsResponse")
public class ContactDetailsResponse {

    @XmlElement(name = "ContactDetails", required = true)
    private Contact contactDetails;

    public Contact getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(Contact contactDetails) {
        this.contactDetails = contactDetails;
    }
}
