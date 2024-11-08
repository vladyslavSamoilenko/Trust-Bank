package com.mthree.trustBank.TrustBank.controllers;

import com.mthree.trustBank.TrustBank.dto.ClientDTO;
import com.mthree.trustBank.TrustBank.entities.Client;
import com.mthree.trustBank.TrustBank.services.employeeService.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/api/clients/register")
    public Client registerClient(@RequestBody ClientDTO client){
        return clientService.create(client);
    }
}
