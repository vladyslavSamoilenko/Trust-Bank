package com.mthree.trustBank.TrustBank.controllers;

import com.mthree.trustBank.TrustBank.entities.Loan;
import com.mthree.trustBank.TrustBank.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    // Получить все кредиты
    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return new ResponseEntity<>(loanService.getAllLoans(), HttpStatus.OK);
    }

    // Получить кредит по ID
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable int id) {
        return new ResponseEntity<>(loanService.getLoanById(id), HttpStatus.OK);
    }

    // Создать новый кредит для клиента
    @PostMapping("/client/{clientId}")
    public ResponseEntity<Loan> createLoanForClient(@PathVariable int clientId, @RequestBody Loan loan) {
        return new ResponseEntity<>(loanService.createLoan(clientId, loan), HttpStatus.CREATED);
    }

    // Удалить кредит
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable int id) {
        loanService.deleteLoan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
