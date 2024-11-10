package com.mthree.trustBank.TrustBank.controllers;

import com.mthree.trustBank.TrustBank.entities.ClientApplicationAccount;
import com.mthree.trustBank.TrustBank.services.ClientApplicationAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients/accounts")
public class ClientApplicationAccountController {

    private final ClientApplicationAccountService clientsApplicationAccountService;

    @Autowired
    public ClientApplicationAccountController(ClientApplicationAccountService clientsApplicationAccountService) {
        this.clientsApplicationAccountService = clientsApplicationAccountService;
    }

    @PostMapping("/client/{clientId}")
    public ResponseEntity<ClientApplicationAccount> createAccountForClient(
            @PathVariable int clientId, @RequestBody ClientApplicationAccount account) {
        return new ResponseEntity<>(clientsApplicationAccountService.createAccountForClient(clientId, account), HttpStatus.CREATED);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<ClientApplicationAccount> getAccountByClientId(@PathVariable int clientId) {
        return new ResponseEntity<>(clientsApplicationAccountService.getAccountByClientId(clientId), HttpStatus.OK);
    }
}
