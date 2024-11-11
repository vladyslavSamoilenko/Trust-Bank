package com.mthree.trustBank.TrustBank.services;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.mthree.trustBank.TrustBank.dto.TransactionHistoryDTO;
import com.mthree.trustBank.TrustBank.entities.Account;
import com.mthree.trustBank.TrustBank.entities.TransactionHistory;
import com.mthree.trustBank.TrustBank.repositories.AccountRepository;
import com.mthree.trustBank.TrustBank.repositories.TransactionHistoryRepository;
import com.mthree.trustBank.TrustBank.services.TransactionHistoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class TransactionHistoryServiceTest {
    @Mock
    private TransactionHistoryRepository transactionHistoryRepository;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TransactionHistoryService transactionHistoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTransaction_Success() {
        TransactionHistoryDTO transactionDTO = new TransactionHistoryDTO();
        transactionDTO.setAccountId(1);
        transactionDTO.setToAccountId(2);
        transactionDTO.setAmount(BigDecimal.valueOf(100.00));
        transactionDTO.setTransactionType("TRANSFER");
        transactionDTO.setDescription("Test Transfer");

        Account account = new Account();
        account.setAccountId(1);

        Account toAccount = new Account();
        toAccount.setAccountId(2);

        TransactionHistory savedTransaction = new TransactionHistory();
        savedTransaction.setTransactionId(1);
        savedTransaction.setAccount(account);  // Ensure account is set
        savedTransaction.setToAccount(toAccount);
        savedTransaction.setAmount(transactionDTO.getAmount());
        savedTransaction.setTransactionType(TransactionHistory.TransactionType.TRANSFER);
        savedTransaction.setDescription(transactionDTO.getDescription());

        when(accountRepository.findById(1)).thenReturn(Optional.of(account));
        when(accountRepository.findById(2)).thenReturn(Optional.of(toAccount));
        when(transactionHistoryRepository.save(any(TransactionHistory.class))).thenReturn(savedTransaction);

        TransactionHistoryDTO result = transactionHistoryService.createTransaction(transactionDTO);

        assertNotNull(result);
        assertEquals(1, result.getAccountId());  // Account ID should match
        assertEquals(100.00, result.getAmount().doubleValue());  // Check amount
        assertEquals("TRANSFER", result.getTransactionType());  // Check transaction type
    }

    @Test
    void testCreateTransaction_AccountNotFound() {
        TransactionHistoryDTO transactionDTO = new TransactionHistoryDTO();
        transactionDTO.setAccountId(1);

        when(accountRepository.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            transactionHistoryService.createTransaction(transactionDTO);
        });

        assertEquals("Account not found", exception.getMessage());
    }
}
