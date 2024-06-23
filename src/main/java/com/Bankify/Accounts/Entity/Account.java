package com.Bankify.Accounts.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account extends MetaDataEntity {

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Id
    @Column(name = "account_number" ,nullable = false)
    private Long accountNumber;

    @Column(name = "account_type", nullable = false)
    private String accountType;
    @Column(name = "branch_address", nullable = false)
    private String branchAddress;


}
