package com.Bankify.Accounts.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Customer",description = "holds customer details ")
public class CustomerDTO {

    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5,max = 30 ,message = "The Name length should be between 5 and 30 ")
    @Schema(description = "Name of the Customer",example = "Sridhar Vadla")
    private String name;

    @NotEmpty(message = "email cannot be null or empty")
    @Email(message = "enter a valid emailId")
    @Schema(description = "EmailId of the customer", example = "SridharVadla234@gmail.com")
    private String email;

    @Pattern(regexp = "[6-9][1-9]{9}" ,message = "The mobile Number should be 10 digits long")
    @Schema(description = "Mobile number of the customer ",example = "1235564685")
    private String mobileNumber;

    @Schema(description = "hold the Account object data ")
    private AccountDTO accountDTO;


}
