package com.mthree.trustBank.TrustBank.repositories;

import com.mthree.trustBank.TrustBank.entities.EmployeeApplicationAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeAccountRepository extends JpaRepository<EmployeeApplicationAccount, Integer> {
    Optional<EmployeeApplicationAccount> findByUsernameAndPassword(String username, String password);
}
