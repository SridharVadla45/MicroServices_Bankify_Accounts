package com.Bankify.Accounts.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {

    private Long accountNumber;

    private String accountType;

    private String branchAddress;

}
