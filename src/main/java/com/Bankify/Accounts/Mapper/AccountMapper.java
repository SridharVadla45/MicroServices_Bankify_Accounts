package com.Bankify.Accounts.Mapper;

import com.Bankify.Accounts.Constants.AccountConstants;
import com.Bankify.Accounts.DTO.AccountDTO;
import com.Bankify.Accounts.Entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDTO accountDTO, Account account) {
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setAccountType(account.getAccountType());
        account.setBranchAddress(account.getBranchAddress());
        return account;
    }

    public static AccountDTO mapToAccountDTO(Account account, AccountDTO accountDTO) {
        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setAccountType(account.getAccountType());
        accountDTO.setBranchAddress(account.getBranchAddress());

        return accountDTO;
    }
}
