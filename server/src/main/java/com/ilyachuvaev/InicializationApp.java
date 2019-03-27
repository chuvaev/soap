package com.ilyachuvaev;

import com.ilyachuvaev.repository.ContactRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InicializationApp {

    @PostConstruct
    void init(){
        ConfigurableApplicationContext context = SpringApplication.run(SoapApplication.class);
        ContactRepository repository = context.getBean(ContactRepository.class);
        Contact contact = new Contact();
        contact.setId(1L);
        contact.setFirstName("John");
        contact.setLastName("Johnson");
        contact.setPhone("+74951512365");
        contact.setEmail("jony@john.com");
        repository.save(contact);

        Contact contact1 = new Contact();
        contact1.setId(2L);
        contact1.setFirstName("Sally");
        contact1.setLastName("Sally");
        contact1.setPhone("+74955693522");
        contact1.setEmail("saly@saly.com");
        repository.save(contact1);

        Contact contact2 = new Contact();
        contact2.setId(3L);
        contact2.setFirstName("Tony");
        contact2.setLastName("Tony");
        contact2.setPhone("+74951512345");
        contact2.setEmail("tony@tony.com");
        repository.save(contact2);

        Contact contact3 = new Contact();
        contact3.setId(4L);
        contact3.setFirstName("Bob");
        contact3.setLastName("Bobby");
        contact3.setPhone("+74987845414");
        contact3.setEmail("bob@bob.com");
        repository.save(contact3);

        Contact contact4 = new Contact();
        contact4.setId(5L);
        contact4.setFirstName("Ruby");
        contact4.setLastName("Ruby");
        contact4.setPhone("+74956546566");
        contact4.setEmail("ruby@ruby.com");
        repository.save(contact4);

    }

    InicializationApp(){}
}
