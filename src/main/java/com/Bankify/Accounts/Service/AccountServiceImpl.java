package com.Bankify.Accounts.Service;

import com.Bankify.Accounts.Constants.AccountConstants;
import com.Bankify.Accounts.DTO.AccountDTO;
import com.Bankify.Accounts.DTO.CustomerDTO;
import com.Bankify.Accounts.Entity.Account;
import com.Bankify.Accounts.Entity.Customer;
import com.Bankify.Accounts.Exception.AccountNotFoundException;
import com.Bankify.Accounts.Exception.CustomerAlreadyExistException;
import com.Bankify.Accounts.Exception.ResourceNotFoundException;
import com.Bankify.Accounts.IAccountService;
import com.Bankify.Accounts.Mapper.AccountMapper;
import com.Bankify.Accounts.Mapper.CustomerMapper;
import com.Bankify.Accounts.Repository.AccountRepository;
import com.Bankify.Accounts.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
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



        customerRepository.save(customer);

        accountRepository.save(generateAccount(customer));


    }

    @Override
    public AccountDTO getAccount(long accountNumber) {
        Optional<Account> accountOptional = accountRepository.findByAccountNumber(accountNumber);
        if (accountOptional.isEmpty()) {
            throw new AccountNotFoundException("Account Not Found with given Account Number :" + accountNumber);
        }
        return AccountMapper.mapToAccountDTO(accountOptional.get(), new AccountDTO());
    }

    @Override
    public CustomerDTO getCustomerDTO(String emailId) {
        Customer customer = customerRepository.findByEmail(emailId).orElseThrow(() -> new ResourceNotFoundException("Customer", "emailId", emailId));
        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Account", "CustomerId", customer.getCustomerId().toString()));
        CustomerDTO customerDTO = CustomerMapper.mapToCustomerDTO(customer, new CustomerDTO());
        customerDTO.setAccountDTO(AccountMapper.mapToAccountDTO(account, new AccountDTO()));
        return customerDTO;
    }

    @Override
    public void updateAccount(String emailId, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findByEmail(emailId).orElseThrow(() -> new ResourceNotFoundException("Customer", "emailId", emailId));
        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Account", "CustomerId", customer.getCustomerId().toString()));
        customer.setName(customerDTO.getName());
        customer.setMobileNumber(customerDTO.getMobileNumber());
        customer.setUpdatedAt(LocalDate.now());
        customer.setUpdatedBy(customerDTO.getName());
        account.setUpdatedAt(LocalDate.now());
        account.setUpdatedBy(customerDTO.getName());
        customerRepository.save(customer);
        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(String emailId) {
        Customer customer = customerRepository.findByEmail(emailId).orElseThrow(() -> new ResourceNotFoundException("Customer", "emailId", emailId));
        customerRepository.deleteById(customer.getCustomerId());
        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Account", "CustomerId", customer.getCustomerId().toString()));
        accountRepository.deleteById(account.getAccountNumber());
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
