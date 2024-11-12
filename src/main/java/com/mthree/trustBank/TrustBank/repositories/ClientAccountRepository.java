package com.mthree.trustBank.TrustBank.repositories;

import com.mthree.trustBank.TrustBank.entities.ClientApplicationAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientAccountRepository extends JpaRepository<ClientApplicationAccount, Integer> {
    Optional<ClientApplicationAccount> findByUsername(String username);
}
