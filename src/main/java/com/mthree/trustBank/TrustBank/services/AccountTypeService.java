package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.dto.AccountTypeDTO;
import com.mthree.trustBank.TrustBank.entities.AccountType;
import com.mthree.trustBank.TrustBank.repositories.AccountTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountTypeService {

    private final AccountTypeRepository accountTypeRepository;

    public AccountTypeService(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    public List<AccountTypeDTO> getAllAccountTypes() {
        return accountTypeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AccountTypeDTO getAccountTypeById(int id) {
        AccountType accountType = accountTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account type not found"));
        return convertToDTO(accountType);
    }

    public AccountTypeDTO createAccountType(AccountTypeDTO accountTypeDTO) {
        AccountType accountType = convertToEntity(accountTypeDTO);
        accountType = accountTypeRepository.save(accountType);
        return convertToDTO(accountType);
    }

    public AccountTypeDTO updateAccountType(int id, AccountTypeDTO accountTypeDTO) {
        AccountType existingAccountType = accountTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account type not found"));
        existingAccountType.setAccountType(accountTypeDTO.getAccountType());
        existingAccountType = accountTypeRepository.save(existingAccountType);
        return convertToDTO(existingAccountType);
    }

    public void deleteAccountType(int id) {
        accountTypeRepository.deleteById(id);
    }

    private AccountTypeDTO convertToDTO(AccountType accountType) {
        AccountTypeDTO dto = new AccountTypeDTO();
        dto.setId(accountType.getId());
        dto.setAccountType(accountType.getAccountType());
        return dto;
    }

    private AccountType convertToEntity(AccountTypeDTO dto) {
        AccountType accountType = new AccountType();
        accountType.setAccountType(dto.getAccountType());
        return accountType;
    }
}
