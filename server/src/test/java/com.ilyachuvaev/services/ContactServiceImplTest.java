package com.ilyachuvaev.services;

import static org.junit.Assert.assertEquals;

import com.ilyachuvaev.entity.ContactMapper;
import com.ilyachuvaev.repository.ContactRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ContactServiceImplTest {

  @Mock
  private ContactServiceImpl recordService;

  @Mock
  private ContactRepository repository;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getContact_forExistingEntity() {
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
    assertEquals(testContact.getId(), result.getId());
    assertEquals(testContact.getFirstName(), result.getFirstName());
    assertEquals(testContact.getLastName(), result.getLastName());
    assertEquals(testContact.getPhone(), result.getPhone());
    assertEquals(testContact.getEmail(), result.getEmail());
  }

  @Test
  public void saveOrUpdate_forExistingEntityClass() { // TODO
    //given:

    //when:

    //then:

  }

  @Test
  public void delete_forExistingEntityClass() { // TODO
    //given:

    //when:

    //then:

  }

  @Test
  public void getContacts_forExistingEntityClass() { // TODO
    //given:

    //when:

    //then:

  }
}
