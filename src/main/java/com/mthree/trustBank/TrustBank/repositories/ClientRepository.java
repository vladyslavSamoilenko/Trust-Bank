package com.mthree.trustBank.TrustBank.repositories;


import com.mthree.trustBank.TrustBank.entities.Client;
import com.mthree.trustBank.TrustBank.entities.ClientApplicationAccount;
import com.mthree.trustBank.TrustBank.entities.EmployeeApplicationAccount;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByClientId(int clientId);
    Optional<Client> findClientByEmail(String email);
}
