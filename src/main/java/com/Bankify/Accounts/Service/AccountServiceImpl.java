package com.Bankify.Accounts.Service;

import com.Bankify.Accounts.Constants.AccountConstants;
import com.Bankify.Accounts.DTO.AccountDTO;
import com.Bankify.Accounts.DTO.CustomerDTO;
import com.Bankify.Accounts.Entity.Account;
import com.Bankify.Accounts.Entity.Customer;
import com.Bankify.Accounts.Exception.CustomerAlreadyExistException;
import com.Bankify.Accounts.IAccountService;
import com.Bankify.Accounts.Mapper.AccountMapper;
import com.Bankify.Accounts.Mapper.CustomerMapper;
import com.Bankify.Accounts.Repository.AccountRepository;
import com.Bankify.Accounts.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;


@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {



    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;


    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        Optional<Customer> customerOptional = customerRepository.findByEmail(customerDTO.getEmail());
        if (customerOptional.isPresent()) {
            throw new CustomerAlreadyExistException("Customer Already Exists with given EmailId :" + customerDTO.getEmail());
        }
        customer.setCreatedAt(LocalDate.now());
        customer.setCreatedBy(customerDTO.getName());
        System.out.println(customer.toString());


        customerRepository.save(customer);

        accountRepository.save(generateAccount(customer));


    }

    private Account generateAccount(Customer customer) {
        long accountNumber = 1000000000L + new Random().nextInt(90000000);
        Account account = new Account();
        account.setCustomerId(customer.getCustomerId());
        account.setAccountNumber(accountNumber);
        account.setAccountType(AccountConstants.SAVING);
        account.setBranchAddress(AccountConstants.ADDRESS);
        account.setCreatedAt(LocalDate.now());
        account.setCreatedBy(customer.getName());
        return account;
    }

}
