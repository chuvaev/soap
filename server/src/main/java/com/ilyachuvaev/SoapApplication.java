package com.ilyachuvaev;

import com.ilyachuvaev.services.ContactServiceImpl;

import javax.xml.ws.Endpoint;

public class SoapApplication {

    public static void main(String[] args){

        Endpoint.publish("http://localhost:8080/webservices",
                new ContactServiceImpl());

        InicializationApp inicializationApp = new InicializationApp();
        inicializationApp.init();

    }
}
