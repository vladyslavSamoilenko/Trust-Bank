package com.mthree.trustBank.TrustBank.controllers;

import com.mthree.trustBank.TrustBank.dto.ClientDTO;
import com.mthree.trustBank.TrustBank.entities.Client;
import com.mthree.trustBank.TrustBank.entities.ClientApplicationAccount;
import com.mthree.trustBank.TrustBank.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // Получить всех клиентов
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    // Получить клиента по ID
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable int id) {
        return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK);
    }

    // Создать нового клиента
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.createClient(client), HttpStatus.CREATED);
    }

    // Обновить данные клиента
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable int id, @RequestBody Client clientDetails) {
        return new ResponseEntity<>(clientService.updateClient(id, clientDetails), HttpStatus.OK);
    }

    // Удалить клиента
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

