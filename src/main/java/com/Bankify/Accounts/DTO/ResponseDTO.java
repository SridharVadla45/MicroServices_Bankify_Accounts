package com.Bankify.Accounts.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Schema(name = "Response",description = "Schema to hold Response Object")
public class ResponseDTO {


    @Schema(description = "Response Status Message")
    private String statusMsg;

    @Schema(description = "Http Status code of the Response", example = "Account Created Successfully ")
    private HttpStatus statusCode;



}
