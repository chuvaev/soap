package com.ilyachuvaev.services;


import com.ilyachuvaev.Contact;

import java.util.List;

public interface ContactService {

    Contact getContactDetails(Long id);

    long saveOrUpdate(Contact contact);

    long delete(Long id);

    List<Contact> getContacts();

}
