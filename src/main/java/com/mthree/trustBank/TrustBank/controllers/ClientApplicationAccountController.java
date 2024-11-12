package com.mthree.trustBank.TrustBank.controllers;

import com.mthree.trustBank.TrustBank.dto.ClientAccountDTO;
import com.mthree.trustBank.TrustBank.services.ClientApplicationAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ClientAccountDTO loginDto) {
        Integer clientId = clientApplicationAccountService.authenticate(loginDto.getUsername(), loginDto.getPassword());
        if (clientId != null) {
            return ResponseEntity.ok(Collections.singletonMap("clientId", clientId));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверное имя пользователя или пароль");
        }
    }
}
