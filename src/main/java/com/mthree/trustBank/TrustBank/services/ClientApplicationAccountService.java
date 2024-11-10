package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.entities.Client;
import com.mthree.trustBank.TrustBank.entities.ClientApplicationAccount;
import com.mthree.trustBank.TrustBank.repositories.ClientAccountRepository;
import com.mthree.trustBank.TrustBank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientApplicationAccountService {

    private final ClientAccountRepository clientsApplicationAccountRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public ClientApplicationAccountService(ClientAccountRepository clientsApplicationAccountRepository,
                                            ClientRepository clientRepository) {
        this.clientsApplicationAccountRepository = clientsApplicationAccountRepository;
        this.clientRepository = clientRepository;
    }

    public ClientApplicationAccount createAccountForClient(int clientId, ClientApplicationAccount account) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Клиент с ID " + clientId + " не найден"));
        account.setClient(client);
        return clientsApplicationAccountRepository.save(account);
    }

    public ClientApplicationAccount getAccountByClientId(int clientId) {
        return clientsApplicationAccountRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Учетная запись клиента с ID " + clientId + " не найдена"));
    }
}
