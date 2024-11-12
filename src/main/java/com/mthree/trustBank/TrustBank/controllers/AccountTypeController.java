package com.mthree.trustBank.TrustBank.controllers;

import com.mthree.trustBank.TrustBank.dto.AccountTypeDTO;
import com.mthree.trustBank.TrustBank.services.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accountTypes")
public class AccountTypeController {

    @Autowired
    private AccountTypeService accountTypeService;

    @GetMapping
    public List<AccountTypeDTO> getAllAccountTypes() {
        return accountTypeService.getAllAccountTypes();
    }

    @GetMapping("/{id}")
    public AccountTypeDTO getAccountTypeById(@PathVariable int id) {
        return accountTypeService.getAccountTypeById(id);
    }

    @PostMapping
    public AccountTypeDTO createAccountType(@RequestBody AccountTypeDTO accountTypeDTO) {
        return accountTypeService.createAccountType(accountTypeDTO);
    }

    @PutMapping("/{id}")
    public AccountTypeDTO updateAccountType(@PathVariable int id, @RequestBody AccountTypeDTO accountTypeDTO) {
        return accountTypeService.updateAccountType(id, accountTypeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountType(@PathVariable int id) {
        accountTypeService.deleteAccountType(id);
    }
}