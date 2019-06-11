package com.ilyachuvaev.services;

import static org.junit.Assert.assertEquals;

import com.ilyachuvaev.entity.ContactMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class ContactServiceImplTest {

  @InjectMocks
  private ContactServiceImpl recordService;

  @Before
  public void setUp(){MockitoAnnotations.initMocks(this); }

  @Test
  public void getContact_forExistingEntity(){
    //given:
    ContactMapper testContact = new ContactMapper();
    testContact.setId(1L);
    testContact.setFirstName("John");
    testContact.setLastName("Johnson");
    testContact.setPhone("+74951512365");
    testContact.setEmail("jony@john.com");

    //when:
    ContactMapper result = recordService.getContact(testContact.getId());

    //then:
    assertEquals(testContact.getId(),result.getId());
    assertEquals(testContact.getFirstName(),result.getFirstName());
    assertEquals(testContact.getLastName(),result.getLastName());
    assertEquals(testContact.getPhone(),result.getPhone());
    assertEquals(testContact.getEmail(),result.getEmail());
  }

  @Test
  public void saveOrUpdate_forExistingEntityClass(){
    //given:


    //when:

    //then:

  }

  @Test
  public void delete_forExistingEntityClass(){
    //given:


    //when:

    //then:

  }

  @Test
  public void getContacts_forExistingEntityClass(){
    //given:


    //when:

    //then:

  }
}
