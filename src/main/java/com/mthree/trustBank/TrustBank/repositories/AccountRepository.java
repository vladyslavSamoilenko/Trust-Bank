package com.mthree.trustBank.TrustBank.repositories;

import com.mthree.trustBank.TrustBank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
    Optional<Account> findByAccountNumber(String accountNumber);
    Optional<Account> findByClient_ClientId(int clientId); // Для одного аккаунта по clientId
    List<Account> findAllByClient_ClientId(int clientId);
}
