package com.ilyachuvaev.services;


import com.ilyachuvaev.Contact;

public interface ContactService {

    Contact getContact(Long id);

    long saveOrUpdate(Contact contact);

    long delete(Long id);

}
