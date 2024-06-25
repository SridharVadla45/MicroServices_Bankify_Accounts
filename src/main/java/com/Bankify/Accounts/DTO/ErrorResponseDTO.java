package com.Bankify.Accounts.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Schema( name = "ErrorResponse",description = "Schema to hold the error Response")
public class ErrorResponseDTO {

    @Schema(description = "field to hold the invocation path URI: ",example = "https://server:port/api/create")
    private String apiPath;

    @Schema(description = "field to hold the Http Status of the Error ", example = "HTTP STATUS CREATED : 200")
    private HttpStatus statusCode;

    @Schema(description = "field to hold the time when error occurred")
    private LocalDate errorTime;

    @Schema(description = "field holds the error description")
    private String errorMsg;
}
