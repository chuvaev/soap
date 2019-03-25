package com.ilyachuvaev.webservices;

import com.ilyachuvaev.entity.Contact;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"id", "contactDetails"})
@XmlRootElement(name = "ContactDetailRequest")
public class ContactDetailsRequest {

    @XmlElement(required = true)
    private Long id;

    @XmlElement(name = "contactDetails", required = true)
    private Contact contactDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contact getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(Contact contactDetails) {
        this.contactDetails = contactDetails;
    }
}
