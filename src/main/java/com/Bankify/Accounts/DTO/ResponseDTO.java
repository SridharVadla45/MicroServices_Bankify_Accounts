package com.Bankify.Accounts.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseDTO {

    private String statusMsg;

    private HttpStatus statusCode;



}
