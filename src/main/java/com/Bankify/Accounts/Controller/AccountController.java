package com.Bankify.Accounts.Controller;

import com.Bankify.Accounts.Constants.AccountConstants;
import com.Bankify.Accounts.DTO.AccountDTO;
import com.Bankify.Accounts.DTO.CustomerDTO;
import com.Bankify.Accounts.DTO.ResponseDTO;
import com.Bankify.Accounts.IAccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountController {

    private IAccountService iAccountService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customerDTO) {

        iAccountService.createAccount(customerDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.MESSAGE_CREATED, HttpStatus.CREATED));

    }

    @GetMapping("/getAccount/{accountNumber}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable @Pattern(regexp = "[0-9]{9}", message = "The accountNumber should be 10digit long ") Long accountNumber) {
        System.out.println(accountNumber);
        AccountDTO accountDTO = iAccountService.getAccount(accountNumber);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountDTO);
    }

    @GetMapping("/getCustomer/{emailId}")
    public ResponseEntity<CustomerDTO> fetchCustomerDetails(@PathVariable @Email(message = "enter a valid emailId") String emailId) {

        CustomerDTO customerDTO = iAccountService.getCustomerDTO(emailId);

        return ResponseEntity.status(HttpStatus.OK).body(customerDTO);

    }

    //update
    @PutMapping("/update/{emailId}")
    public ResponseEntity<ResponseDTO> updateCustomerDetails(@PathVariable
                                                             @Email(message = "enter a valid emailId")
                                                             String emailId, @Valid @RequestBody CustomerDTO customerDTO) {

        iAccountService.updateAccount(emailId, customerDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO("Account details updated successfully ", HttpStatus.OK));
    }

    @DeleteMapping("/delete/{emailId}")
    public ResponseEntity<ResponseDTO> deleteAccountDetails(@PathVariable
                                                            @Email(message = "enter a valid emailId")
                                                            String emailId) {
        iAccountService.deleteAccount(emailId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO("Account deleted Successfully ", HttpStatus.OK));
    }
}
