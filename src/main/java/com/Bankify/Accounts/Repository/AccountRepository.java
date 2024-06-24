package com.Bankify.Accounts.Repository;

import com.Bankify.Accounts.Entity.Account;
import com.Bankify.Accounts.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(Long accountNumber);
}
