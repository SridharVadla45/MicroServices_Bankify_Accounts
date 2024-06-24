package com.Bankify.Accounts.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    @Pattern(regexp = "[0-9]{9}" ,message = "The account should be 10digit long ")
    private Long accountNumber;

    @NotEmpty
    private String accountType;

    @NotEmpty
    private String branchAddress;

}
