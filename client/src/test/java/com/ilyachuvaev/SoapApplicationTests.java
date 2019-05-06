package com.ilyachuvaev;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SoapApplicationTests {

    @Autowired
    private SoapClient soapClient;

    @Test
    public void testGetContact(){
        Contact contact = new Contact();
        contact.setId(1L);
        contact.setFirstName("John");
        contact.setLastName("Johnson");
        contact.setPhone("+74951512365");
        contact.setEmail("jony@john.com");
        assertThat(soapClient.getContact(contact.getId())).isEqualTo(contact);
    }

    @Test
    public void testAddContact(){
        ContactRequest contactRequest = new ContactRequest();
        Contact contact = new Contact();
        contact.setId(7L);
        contact.setFirstName("Millow");
        contact.setLastName("Whollis");
        contact.setPhone("+74562369865");
        contact.setEmail("mill@whollis.com");
        contactRequest.setContact(contact);
        assertThat(soapClient.addContact(contactRequest)).isEqualTo(contact.getId());
    }
}
