package com.ilyachuvaev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contact", propOrder = {"id", "firstName", "lastName", "phone", "email"})
public class Contact implements Serializable {

    @Id
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
