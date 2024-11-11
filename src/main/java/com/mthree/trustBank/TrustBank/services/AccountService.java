package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.dto.AccountDTO;
import com.mthree.trustBank.TrustBank.entities.Account;
import com.mthree.trustBank.TrustBank.entities.AccountType;
import com.mthree.trustBank.TrustBank.entities.Client;
import com.mthree.trustBank.TrustBank.repositories.AccountRepository;
import com.mthree.trustBank.TrustBank.repositories.AccountTypeRepository;
import com.mthree.trustBank.TrustBank.repositories.ClientRepository;
import org.springframework.stereotype.Service;

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
        account = accountRepository.save(account);
        return convertToDTO(account);
    }

    public AccountDTO updateAccount(int id, AccountDTO accountDTO) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        existingAccount.setBalance(accountDTO.getBalance());
        // Update other fields if needed, such as account type and account number
        existingAccount.setAccountNumber(accountDTO.getAccountNumber());
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
        dto.setAccountNumber(account.getAccountNumber()); // Add account number to DTO
        return dto;
    }

    private Account convertToEntity(AccountDTO dto) {
        Account account = new Account();

        // Retrieve and set the client from the repository
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        account.setClient(client);

        // Retrieve and set the account type from the repository
        AccountType accountType = accountTypeRepository.findById(dto.getAccountTypeId())
                .orElseThrow(() -> new RuntimeException("Account type not found"));
        account.setAccountType(accountType);

        account.setBalance(dto.getBalance());
        account.setOpenedDate(dto.getOpenedDate());
        account.setAccountNumber(dto.getAccountNumber()); // Set the account number in the entity

        return account;
    }
}
