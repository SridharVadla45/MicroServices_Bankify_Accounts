package com.Bankify.Accounts.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Account",
        description = "schema to hold Account details"
)
public class AccountDTO {

    @Pattern(regexp = "[0-9]{9}" ,message = "The account should be 10digit long ")
    @Schema(description = "Account number of the customer " ,example = "1010201009")
    private Long accountNumber;

    @NotEmpty
    @Schema(description = "Type of the Account ",example = "SAVINGS")
    private String accountType;

    @NotEmpty
    @Schema(description = "holds the address of the Bank ",example = "123 saintforge ,London  Europe")
    private String branchAddress;

}
