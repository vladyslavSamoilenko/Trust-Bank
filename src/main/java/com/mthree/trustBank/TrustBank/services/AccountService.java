package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.dto.AccountDTO;
import com.mthree.trustBank.TrustBank.entities.Account;
import com.mthree.trustBank.TrustBank.entities.AccountType;
import com.mthree.trustBank.TrustBank.entities.Client;
import com.mthree.trustBank.TrustBank.repositories.AccountRepository;
import com.mthree.trustBank.TrustBank.repositories.AccountTypeRepository;
import com.mthree.trustBank.TrustBank.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;
    private final AccountTypeRepository accountTypeRepository;

    public AccountService(AccountRepository accountRepository, ClientRepository clientRepository, AccountTypeRepository accountTypeRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.accountTypeRepository = accountTypeRepository;
    }

    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AccountDTO getAccountById(int id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return convertToDTO(account);
    }

    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = convertToEntity(accountDTO);

        // Генерация уникального номера счета
        String generatedAccountNumber = generateAccountNumber();
        account.setAccountNumber(generatedAccountNumber);

        account = accountRepository.save(account);
        return convertToDTO(account);
    }

    public AccountDTO updateAccount(int id, AccountDTO accountDTO) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        existingAccount.setBalance(accountDTO.getBalance());

        // Обновление типа аккаунта, если требуется
        AccountType accountType = accountTypeRepository.findById(accountDTO.getAccountTypeId())
                .orElseThrow(() -> new RuntimeException("Account type not found"));
        existingAccount.setAccountType(accountType);

        existingAccount = accountRepository.save(existingAccount);
        return convertToDTO(existingAccount);
    }

    public void deleteAccount(int id) {
        accountRepository.deleteById(id);
    }

    private AccountDTO convertToDTO(Account account) {
        AccountDTO dto = new AccountDTO();
        dto.setAccountId(account.getAccountId());
        dto.setClientId(account.getClient().getClientId());
        dto.setAccountTypeId(account.getAccountType().getId());
        dto.setBalance(account.getBalance());
        dto.setOpenedDate(account.getOpenedDate());
        dto.setAccountNumber(account.getAccountNumber());
        return dto;
    }

    private Account convertToEntity(AccountDTO dto) {
        Account account = new Account();

        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        account.setClient(client);

        AccountType accountType = accountTypeRepository.findById(dto.getAccountTypeId())
                .orElseThrow(() -> new RuntimeException("Account type not found"));
        account.setAccountType(accountType);

        account.setBalance(dto.getBalance() != null ? dto.getBalance() : BigDecimal.ZERO);
        account.setOpenedDate(Date.valueOf(LocalDate.now())); // Устанавливаем текущую дату как дату открытия

        return account;
    }

    private String generateAccountNumber() {
        // Генерация уникального 10-значного номера счета
        return "ACCT-" + (int)(Math.random() * 1_000_000_000);
    }
    public List<AccountDTO> getAccountsByClientId(int clientId) {
        List<Account> accounts = accountRepository.findAllByClient_ClientId(clientId);
        return accounts.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}

