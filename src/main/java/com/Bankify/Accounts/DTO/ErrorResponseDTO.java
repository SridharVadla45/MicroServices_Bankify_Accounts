package com.Bankify.Accounts.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {

    private String apiPath;

    private HttpStatus statusCode;

    private LocalDate errorTime;

    private String errorMsg;
}
