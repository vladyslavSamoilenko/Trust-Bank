package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.dto.BankAccountDTO;
import com.mthree.trustBank.TrustBank.entities.BankAccount;
import com.mthree.trustBank.TrustBank.repositories.BankAccountRepository;
import com.mthree.trustBank.TrustBank.repositories.ClientRepository;
import com.mthree.trustBank.TrustBank.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository, ClientRepository clientRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.clientRepository = clientRepository;
    }

    // Получить все счета
    public List<BankAccount> getAllAccounts() {
        return bankAccountRepository.findAll();
    }

    // Найти счет по ID
    public BankAccount getAccountById(int id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Счет с ID " + id + " не найден"));
    }

    // Создать новый счет для клиента
    public BankAccount createAccount(int clientId, BankAccount account) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Клиент с ID " + clientId + " не найден"));
        account.setClient(client);
        return bankAccountRepository.save(account);
    }

    // Обновить баланс счета
    public BankAccount updateBalance(int accountId, BigDecimal newBalance) {
        BankAccount account = bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Счет с ID " + accountId + " не найден"));
        account.setBalance(newBalance);
        return bankAccountRepository.save(account);
    }

    // Удалить счет
    public void deleteAccount(int id) {
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Счет с ID " + id + " не найден"));
        bankAccountRepository.delete(account);
    }
}
