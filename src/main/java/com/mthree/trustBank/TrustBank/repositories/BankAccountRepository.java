package com.mthree.trustBank.TrustBank.repositories;

import com.mthree.trustBank.TrustBank.entities.BankAccount;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
    List<BankAccount> findByClient_ClientId(int clientId);
}
