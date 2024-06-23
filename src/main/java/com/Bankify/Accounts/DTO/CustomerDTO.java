package com.Bankify.Accounts.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {


    private String name;

    private String email;

    private String mobileNumber;


}
