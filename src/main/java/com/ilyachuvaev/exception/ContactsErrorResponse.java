package com.ilyachuvaev.exception;

import lombok.Data;

@Data
public class ContactsErrorResponse {

    private int status;
    private String message;
    private long timestamp;

}
