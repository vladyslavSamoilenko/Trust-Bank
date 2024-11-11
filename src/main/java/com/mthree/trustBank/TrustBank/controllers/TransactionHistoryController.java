package com.mthree.trustBank.TrustBank.controllers;

import com.mthree.trustBank.TrustBank.dto.TransactionHistoryDTO;
import com.mthree.trustBank.TrustBank.services.TransactionHistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionHistoryController {

    @Autowired
    private TransactionHistoryService transactionHistoryService;

    @GetMapping
    public List<TransactionHistoryDTO> getAllTransactions() {
        return transactionHistoryService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public TransactionHistoryDTO getTransactionById(@PathVariable int id) {
        return transactionHistoryService.getTransactionById(id);
    }

    @PostMapping
    public TransactionHistoryDTO createTransaction(@Valid @RequestBody TransactionHistoryDTO transactionDTO) {
        return transactionHistoryService.createTransaction(transactionDTO);
    }

    @PutMapping("/{id}")
    public TransactionHistoryDTO updateTransaction(@PathVariable int id, @RequestBody TransactionHistoryDTO transactionDTO) {
        return transactionHistoryService.updateTransaction(id, transactionDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable int id) {
        transactionHistoryService.deleteTransaction(id);
    }
}
