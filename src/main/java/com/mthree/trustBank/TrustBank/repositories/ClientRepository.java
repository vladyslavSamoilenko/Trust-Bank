package com.mthree.trustBank.TrustBank.repositories;


import com.mthree.trustBank.TrustBank.entities.Client;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
