package com.Bankify.Accounts.DTO;

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
public class CustomerDTO {

    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5,max = 30 ,message = "The Name length should be between 5 and 30 ")
    private String name;

    @NotEmpty(message = "email cannot be null or empty")
    @Email(message = "enter a valid emailId")
    private String email;

    @Pattern(regexp = "[6-9][1-9]{9}" ,message = "The mobile Number should be 10 digits long")
    private String mobileNumber;

    private AccountDTO accountDTO;


}
