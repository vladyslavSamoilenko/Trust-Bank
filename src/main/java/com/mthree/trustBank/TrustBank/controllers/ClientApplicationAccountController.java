package com.mthree.trustBank.TrustBank.controllers;

import com.mthree.trustBank.TrustBank.dto.ClientAccountDTO;
import com.mthree.trustBank.TrustBank.services.ClientApplicationAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientApplicationAccounts")
public class ClientApplicationAccountController {

    @Autowired
    private ClientApplicationAccountService clientApplicationAccountService;

    @GetMapping
    public List<ClientAccountDTO> getAllClientApplicationAccounts() {
        return clientApplicationAccountService.getAllClientApplicationAccounts();
    }

    @GetMapping("/{id}")
    public ClientAccountDTO getClientApplicationAccountById(@PathVariable int id) {
        return clientApplicationAccountService.getClientApplicationAccountById(id);
    }

    @PostMapping
    public ClientAccountDTO createClientApplicationAccount(@RequestBody ClientAccountDTO dto) {
        return clientApplicationAccountService.createClientApplicationAccount(dto);
    }

    @PutMapping("/{id}")
    public ClientAccountDTO updateClientApplicationAccount(@PathVariable int id, @RequestBody ClientAccountDTO dto) {
        return clientApplicationAccountService.updateClientApplicationAccount(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteClientApplicationAccount(@PathVariable int id) {
        clientApplicationAccountService.deleteClientApplicationAccount(id);
    }
}
