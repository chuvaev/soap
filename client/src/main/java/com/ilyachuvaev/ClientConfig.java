package com.ilyachuvaev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;


@Configuration
@PropertySource("classpath:client.properties")
public class ClientConfig {

    @Bean
    Jaxb2Marshaller jaxb2Marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("common.target.classes.com.ilyachuvaev");
        return jaxb2Marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate(){
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(jaxb2Marshaller());
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
        webServiceTemplate.setDefaultUri("http://localhost:8080/ws/contacts");
        return webServiceTemplate;
    }
}
