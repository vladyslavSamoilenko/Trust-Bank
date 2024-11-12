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
        return clientRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = convertToEntity(clientDTO);
        Client savedClient = clientRepository.save(client);
        return convertToDTO(savedClient);
    }

    public ClientDTO updateClient(int id, ClientDTO clientDTO) {
        return clientRepository.findById(id).map(existingClient -> {
            existingClient.setFirstName(clientDTO.getFirstName());
            existingClient.setLastName(clientDTO.getLastName());
            // Update other fields
            Client updatedClient = clientRepository.save(existingClient);
            return convertToDTO(updatedClient);
        }).orElse(null);
    }

    public boolean deleteClient(int id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private ClientDTO convertToDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setClientId(client.getClientId());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setDateOfBirth(client.getDateOfBirthday());
        dto.setPhone(client.getPhone());
        dto.setEmail(client.getEmail());
        dto.setCity(client.getCity());
        dto.setAddress(client.getAddress()); // Add this line
        dto.setCitizenship(client.getCitizenship());
        return dto;
    }

    private Client convertToEntity(ClientDTO dto) {
        Client client = new Client();
        client.setFirstName(dto.getFirstName());
        client.setLastName(dto.getLastName());
        client.setDateOfBirthday(dto.getDateOfBirth());
        client.setPhone(dto.getPhone());
        client.setEmail(dto.getEmail());
        client.setCity(dto.getCity());
        client.setAddress(dto.getAddress()); // Убедитесь, что эта строка присутствует
        client.setCitizenship(dto.getCitizenship());
        return client;
    }
}