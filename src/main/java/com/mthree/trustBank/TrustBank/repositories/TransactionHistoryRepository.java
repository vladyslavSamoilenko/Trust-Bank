package com.mthree.trustBank.TrustBank.repositories;

import com.mthree.trustBank.TrustBank.entities.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Integer> { }

