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
public class Customer extends MetaDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile_number")
    private String mobileNumber;


}
