package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.dto.ClientAccountDTO;
import com.mthree.trustBank.TrustBank.entities.Client;
import com.mthree.trustBank.TrustBank.entities.ClientApplicationAccount;
import com.mthree.trustBank.TrustBank.repositories.ClientAccountRepository;
import com.mthree.trustBank.TrustBank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientApplicationAccountService {

    private final ClientAccountRepository clientApplicationAccountRepository;
    private final ClientRepository clientRepository;

    public ClientApplicationAccountService(ClientAccountRepository clientApplicationAccountRepository,
                                           ClientRepository clientRepository) {
        this.clientApplicationAccountRepository = clientApplicationAccountRepository;
        this.clientRepository = clientRepository;
    }

    public List<ClientAccountDTO> getAllClientApplicationAccounts() {
        return clientApplicationAccountRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ClientAccountDTO getClientApplicationAccountById(int id) {
        ClientApplicationAccount account = clientApplicationAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client application account not found"));
        return convertToDTO(account);
    }

    public ClientAccountDTO createClientApplicationAccount(ClientAccountDTO dto) {
        ClientApplicationAccount account = convertToEntity(dto);
        account = clientApplicationAccountRepository.save(account);
        return convertToDTO(account);
    }

    public ClientAccountDTO updateClientApplicationAccount(int id, ClientAccountDTO dto) {
        ClientApplicationAccount existingAccount = clientApplicationAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client application account not found"));
        existingAccount.setUsername(dto.getUsername());
        existingAccount.setPassword(dto.getPassword());
        existingAccount = clientApplicationAccountRepository.save(existingAccount);
        return convertToDTO(existingAccount);
    }

    public void deleteClientApplicationAccount(int id) {
        clientApplicationAccountRepository.deleteById(id);
    }

    private ClientAccountDTO convertToDTO(ClientApplicationAccount account) {
        ClientAccountDTO dto = new ClientAccountDTO();
        dto.setClientId(account.getIdClient());
        dto.setUsername(account.getUsername());
        dto.setPassword(account.getPassword());
        return dto;
    }

    private ClientApplicationAccount convertToEntity(ClientAccountDTO dto) {
        ClientApplicationAccount account = new ClientApplicationAccount();
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        account.setClient(client);
        account.setUsername(dto.getUsername());
        account.setPassword(dto.getPassword());
        return account;
    }
}