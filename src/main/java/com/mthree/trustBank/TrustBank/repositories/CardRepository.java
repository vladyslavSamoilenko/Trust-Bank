package com.mthree.trustBank.TrustBank.repositories;

import com.mthree.trustBank.TrustBank.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Integer> {
    Optional<Card> findByCardNumber(String cardNumber);
}
