package com.Bankify.Accounts.Controller;

import com.Bankify.Accounts.Constants.AccountConstants;
import com.Bankify.Accounts.DTO.AccountDTO;
import com.Bankify.Accounts.DTO.CustomerDTO;
import com.Bankify.Accounts.DTO.ResponseDTO;
import com.Bankify.Accounts.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Account MicroService CRUD Controller ", description = "Account Controller exposing CRUD endpoints ")

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountController {

    private IAccountService iAccountService;

    @Operation(description = "endpoints which creates new customer & Account in Bankify Application")
    @ApiResponse(responseCode = "201", description = "HTTP STATUS CREATED")

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customerDTO) {

        iAccountService.createAccount(customerDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(AccountConstants.MESSAGE_CREATED, HttpStatus.CREATED));

    }

    @Operation(description = "endpoints which fetches  Account by AccountNumber in Bankify Application")
    @ApiResponse(responseCode = "200", description = "HTTP STATUS SUCCESS ")

    @GetMapping("/getAccount/{accountNumber}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable @Pattern(regexp = "[0-9]{9}", message = "The accountNumber should be 10digit long ") Long accountNumber) {
        System.out.println(accountNumber);
        AccountDTO accountDTO = iAccountService.getAccount(accountNumber);

        return ResponseEntity.status(HttpStatus.OK).body(accountDTO);
    }

    @Operation(description = "endpoints which fetches  customer details  by emailID in Bankify Application")
    @ApiResponse(responseCode = "200", description = "HTTP STATUS SUCCESS ")
    @GetMapping("/getCustomer/{emailId}")
    public ResponseEntity<CustomerDTO> fetchCustomerDetails(@PathVariable @Email(message = "enter a valid emailId") String emailId) {

        CustomerDTO customerDTO = iAccountService.getCustomerDTO(emailId);

        return ResponseEntity.status(HttpStatus.OK).body(customerDTO);

    }

    @Operation(description = "endpoints which updates  CustomerDetails in Bankify Application")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "HTTP STATUS SUCCESS "))
    @PutMapping("/update/{emailId}")
    public ResponseEntity<ResponseDTO> updateCustomerDetails(@PathVariable @Email(message = "enter a valid emailId") String emailId, @Valid @RequestBody CustomerDTO customerDTO) {

        iAccountService.updateAccount(emailId, customerDTO);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("Account details updated successfully ", HttpStatus.OK));
    }

    @Operation(

            description = "endpoint to delete the customer details in Bankify Application")
    @ApiResponse(responseCode = "200", description = "HTTP STATUS SUCCESS")

    @DeleteMapping("/delete/{emailId}")
    public ResponseEntity<ResponseDTO> deleteAccountDetails(@PathVariable @Email(message = "enter a valid emailId") String emailId) {
        iAccountService.deleteAccount(emailId);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("Account deleted Successfully ", HttpStatus.OK));
    }
}
