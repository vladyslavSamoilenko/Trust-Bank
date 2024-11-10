package com.mthree.trustBank.TrustBank.repositories;

import com.mthree.trustBank.TrustBank.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    Optional<Loan> findByAccount_AccountId(int accountId);
}
