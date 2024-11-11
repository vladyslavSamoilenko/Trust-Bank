package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.dto.ClientDTO;
import com.mthree.trustBank.TrustBank.entities.Client;
import com.mthree.trustBank.TrustBank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO getClientById(int id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return convertToDTO(client);
    }

    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = convertToEntity(clientDTO);
        client = clientRepository.save(client);
        return convertToDTO(client);
    }

    public ClientDTO updateClient(int id, ClientDTO clientDTO) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        existingClient.setFirstName(clientDTO.getFirstName());
        existingClient.setLastName(clientDTO.getLastName());
        // Update other fields as necessary
        existingClient = clientRepository.save(existingClient);
        return convertToDTO(existingClient);
    }

    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }

    private ClientDTO convertToDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setClientId(client.getClientId());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        // Map other fields as necessary
        return dto;
    }

    private Client convertToEntity(ClientDTO dto) {
        Client client = new Client();
        client.setFirstName(dto.getFirstName());
        client.setLastName(dto.getLastName());
        // Map other fields as necessary
        return client;
    }
}