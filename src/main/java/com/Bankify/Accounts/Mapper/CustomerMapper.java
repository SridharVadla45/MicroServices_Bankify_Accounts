package com.Bankify.Accounts.Mapper;

import com.Bankify.Accounts.DTO.CustomerDTO;
import com.Bankify.Accounts.Entity.Customer;

public class CustomerMapper {

    public static Customer mapToCustomer(CustomerDTO customerDTO, Customer customer) {
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setMobileNumber(customerDTO.getMobileNumber());
        return customer;
    }

    public static CustomerDTO mapToCustomerDTO(Customer customer, CustomerDTO customerDTO) {
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setMobileNumber(customer.getMobileNumber());
        return customerDTO;
    }
}
