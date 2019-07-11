package com.ilyachuvaev.entity;

import com.ilyachuvaev.Contact;
import com.ilyachuvaev.ObjectFactory;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ContactMapper extends Contact{

//  private Contact contact;

  @Id
  @GeneratedValue
  private long id;
  @Column
  private String firstName;
  @Column
  private String lastName;
  @Column
  private String phone;
  @Column
  private String email;

  public ContactMapper() {
//    this.contact = new ObjectFactory().createContact();
    this.id = super.id;
    this.firstName = super.firstName;
    this.lastName = super.lastName;
    this.phone = super.phone;
    this.email = super.email;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
