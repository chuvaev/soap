package com.ilyachuvaev;

import com.ilyachuvaev.entity.ContactMapper;
import com.ilyachuvaev.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InicializationApp {

  private final ContactRepository repository;

  @PostConstruct
  public void init() {
    ContactMapper contact = new ContactMapper();
    contact.setId(1L);
    contact.setFirstName("John");
    contact.setLastName("Johnson");
    contact.setPhone("+74951512365");
    contact.setEmail("jony@john.com");
    repository.save(contact);

    ContactMapper contact1 = new ContactMapper();
    contact1.setId(2L);
    contact1.setFirstName("Sally");
    contact1.setLastName("Sally");
    contact1.setPhone("+74955693522");
    contact1.setEmail("saly@saly.com");
    repository.save(contact1);

    ContactMapper contact2 = new ContactMapper();
    contact2.setId(3L);
    contact2.setFirstName("Tony");
    contact2.setLastName("Tony");
    contact2.setPhone("+74951512345");
    contact2.setEmail("tony@tony.com");
    repository.save(contact2);

    ContactMapper contact3 = new ContactMapper();
    contact3.setId(4L);
    contact3.setFirstName("Bob");
    contact3.setLastName("Bobby");
    contact3.setPhone("+74987845414");
    contact3.setEmail("bob@bob.com");
    repository.save(contact3);

    ContactMapper contact4 = new ContactMapper();
    contact4.setId(5L);
    contact4.setFirstName("Ruby");
    contact4.setLastName("Ruby");
    contact4.setPhone("+74956546566");
    contact4.setEmail("ruby@ruby.com");
    repository.save(contact4);

    ContactMapper contact5 = new ContactMapper();
    contact5.setId(6L);
    contact5.setFirstName("Tair");
    contact5.setLastName("Polish");
    contact5.setPhone("+76523265984");
    contact5.setEmail("tair@pol.com");
    repository.save(contact5);
  }
}
