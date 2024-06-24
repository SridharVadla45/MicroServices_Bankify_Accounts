package com.Bankify.Accounts.Exception;


import com.Bankify.Accounts.DTO.ErrorResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        validationErrorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String validationMsg = error.getDefaultMessage();
            validationErrors.put(fieldName, validationMsg);
        });
        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }

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

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ErrorResponseDTO> handleAccountNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponseDTO(
                                webRequest.getDescription(false).replace("uri=", ""),
                                HttpStatus.NOT_FOUND,
                                LocalDate.now(),
                                resourceNotFoundException.getMessage()
                        )
                );
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorResponseDTO> handleAccountNotFoundException(Exception exception, WebRequest webRequest) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponseDTO(
                                webRequest.getDescription(false).replace("uri=", ""),
                                HttpStatus.NOT_FOUND,
                                LocalDate.now(),
                                exception.getMessage()
                        )
                );
    }

}
