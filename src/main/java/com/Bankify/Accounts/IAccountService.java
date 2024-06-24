package com.Bankify.Accounts;

import com.Bankify.Accounts.DTO.AccountDTO;
import com.Bankify.Accounts.DTO.CustomerDTO;

public interface IAccountService {

    void createAccount(CustomerDTO customerDTO);

    AccountDTO getAccount(long accountNumber);
}
