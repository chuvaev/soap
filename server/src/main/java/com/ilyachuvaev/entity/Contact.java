package com.ilyachuvaev.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Contact", propOrder = {"id", "firstName", "lastName", "phone", "email"})
public class Contact implements Serializable {

    @XmlElement(name = "id", required = true)
    private Long id;
    @XmlElement(name = "firstName", required = true)
    private String firstName;
    @XmlElement(name = "lastName", required = true)
    private String lastName;
    @XmlElement(name = "phone", required = true)
    private String phone;
    @XmlElement(name = "email", required = true)
    private String email;


}

