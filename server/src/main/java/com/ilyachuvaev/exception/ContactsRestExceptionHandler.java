package com.ilyachuvaev.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContactsRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ContactsErrorResponse> handlerAllException(Exception exc){
        ContactsErrorResponse contactsErrorResponse = new ContactsErrorResponse();
        contactsErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        contactsErrorResponse.setMessage(exc.getMessage());
        contactsErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(contactsErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
