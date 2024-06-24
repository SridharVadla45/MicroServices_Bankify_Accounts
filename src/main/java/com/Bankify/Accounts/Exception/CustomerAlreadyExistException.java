package com.Bankify.Accounts.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class CustomerAlreadyExistException extends RuntimeException{

    public CustomerAlreadyExistException(String message) {
        super(message);
    }
}
