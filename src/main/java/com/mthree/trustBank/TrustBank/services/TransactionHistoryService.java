package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.dto.TransactionHistoryDTO;
import com.mthree.trustBank.TrustBank.entities.Account;
import com.mthree.trustBank.TrustBank.entities.TransactionHistory;
import com.mthree.trustBank.TrustBank.repositories.AccountRepository;
import com.mthree.trustBank.TrustBank.repositories.TransactionHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionHistoryService {

    private final TransactionHistoryRepository transactionHistoryRepository;
    private final AccountRepository accountRepository;

    public TransactionHistoryService(TransactionHistoryRepository transactionHistoryRepository, AccountRepository accountRepository) {
        this.transactionHistoryRepository = transactionHistoryRepository;
        this.accountRepository = accountRepository;
    }

    public List<TransactionHistoryDTO> getAllTransactions() {
        return transactionHistoryRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TransactionHistoryDTO getTransactionById(int id) {
        TransactionHistory transaction = transactionHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        return convertToDTO(transaction);
    }

    public TransactionHistoryDTO createTransaction(TransactionHistoryDTO transactionDTO) {
        TransactionHistory transaction = convertToEntity(transactionDTO);
        transaction = transactionHistoryRepository.save(transaction);
        return convertToDTO(transaction);
    }

    public TransactionHistoryDTO updateTransaction(int id, TransactionHistoryDTO transactionDTO) {
        TransactionHistory existingTransaction = transactionHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        existingTransaction.setAmount(transactionDTO.getAmount());
        // Update other fields as necessary
        existingTransaction = transactionHistoryRepository.save(existingTransaction);
        return convertToDTO(existingTransaction);
    }

    public void deleteTransaction(int id) {
        transactionHistoryRepository.deleteById(id);
    }

    private TransactionHistoryDTO convertToDTO(TransactionHistory transaction) {
        TransactionHistoryDTO dto = new TransactionHistoryDTO();
        dto.setTransactionId(transaction.getTransactionId());
        dto.setAccountId(transaction.getAccount().getAccountId());
        dto.setToAccountId(transaction.getToAccount().getAccountId());
        dto.setAmount(transaction.getAmount());
        dto.setTransactionType(transaction.getTransactionType().toString());
        dto.setTransactionTime(transaction.getTransactionTime());
        dto.setDescription(transaction.getDescription());
        return dto;
    }

    private TransactionHistory convertToEntity(TransactionHistoryDTO dto) {
        TransactionHistory transaction = new TransactionHistory();

        Account account = accountRepository.findById(dto.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));
        Account toAccount = accountRepository.findById(dto.getToAccountId())
                .orElseThrow(() -> new RuntimeException("To Account not found"));

        transaction.setAccount(account);
        transaction.setToAccount(toAccount);

        transaction.setAmount(dto.getAmount());
        transaction.setTransactionType(TransactionHistory.TransactionType.valueOf(dto.getTransactionType().toUpperCase()));
        transaction.setTransactionTime(dto.getTransactionTime());
        transaction.setDescription(dto.getDescription());

        return transaction;
    }
}