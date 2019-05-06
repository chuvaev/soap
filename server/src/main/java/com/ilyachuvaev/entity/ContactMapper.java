package com.ilyachuvaev.entity;

import com.ilyachuvaev.Contact;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ContactMapper extends Contact{

    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public ContactMapper(){
        this.id = super.getId();
        this.firstName = super.getFirstName();
        this.lastName = super.getLastName();
        this.phone = super.getPhone();
        this.email = super.getEmail();
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
