package com.mthree.trustBank.TrustBank.controllers;

import com.mthree.trustBank.TrustBank.entities.BankAccount;
import com.mthree.trustBank.TrustBank.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    // Получить все счета
    @GetMapping
    public ResponseEntity<List<BankAccount>> getAllAccounts() {
        return new ResponseEntity<>(bankAccountService.getAllAccounts(), HttpStatus.OK);
    }

    // Получить счет по ID
    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getAccountById(@PathVariable int id) {
        return new ResponseEntity<>(bankAccountService.getAccountById(id), HttpStatus.OK);
    }

    // Создать новый счет для клиента
    @PostMapping("/client/{clientId}")
    public ResponseEntity<BankAccount> createAccountForClient(@PathVariable int clientId, @RequestBody BankAccount account) {
        return new ResponseEntity<>(bankAccountService.createAccount(clientId, account), HttpStatus.CREATED);
    }

    // Обновить баланс счета
    @PutMapping("/{accountId}/balance")
    public ResponseEntity<BankAccount> updateBalance(@PathVariable int accountId, @RequestParam BigDecimal newBalance) {
        return new ResponseEntity<>(bankAccountService.updateBalance(accountId, newBalance), HttpStatus.OK);
    }

    // Удалить счет
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int id) {
        bankAccountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}