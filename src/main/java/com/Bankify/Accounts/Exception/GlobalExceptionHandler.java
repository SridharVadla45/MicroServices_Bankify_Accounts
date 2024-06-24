package com.Bankify.Accounts.Exception;


import com.Bankify.Accounts.DTO.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {CustomerAlreadyExistException.class})
    public ResponseEntity<ErrorResponseDTO> handleCustomerAlreadyExistException(CustomerAlreadyExistException customerAlreadyExistException, WebRequest webRequest) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponseDTO(
                                webRequest.getDescription(false).replace("uri=", ""),
                                HttpStatus.BAD_REQUEST,
                                LocalDate.now(),
                                customerAlreadyExistException.getMessage()
                        )
                );
    }

    @ExceptionHandler(value = {AccountNotFoundException.class})
    public ResponseEntity<ErrorResponseDTO> handleAccountNotFoundException(AccountNotFoundException accountNotFoundException, WebRequest webRequest) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponseDTO(
                                webRequest.getDescription(false).replace("uri=", ""),
                                HttpStatus.NOT_FOUND,
                                LocalDate.now(),
                                accountNotFoundException.getMessage()
                        )
                );
    }

}
