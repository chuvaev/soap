package com.ilyachuvaev.services;

import com.ilyachuvaev.entity.ContactMapper;

public interface ContactService {

  ContactMapper getContact(Long id);

  long saveOrUpdate(ContactMapper contact);

  long delete(Long id);

}
