package com.mthree.trustBank.TrustBank.repositories;

import com.mthree.trustBank.TrustBank.entities.ClientApplicationAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientAccountRepository extends JpaRepository<ClientApplicationAccount, Integer> {

    Optional<ClientApplicationAccount> findByUsername(String username);
}
