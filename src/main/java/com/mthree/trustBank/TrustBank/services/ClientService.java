package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.dto.ClientDTO;
import com.mthree.trustBank.TrustBank.entities.Client;
import com.mthree.trustBank.TrustBank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Получить всех клиентов
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Найти клиента по ID
    public Client getClientById(int id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Клиент с ID " + id + " не найден"));
    }

    // Создать нового клиента
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    // Обновить данные клиента
    public Client updateClient(int id, Client clientDetails) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Клиент с ID " + id + " не найден"));

        client.setFirstName(clientDetails.getFirstName());
        client.setLastName(clientDetails.getLastName());
        client.setDateOfBirth(clientDetails.getDateOfBirth());
        client.setPhone(clientDetails.getPhone());
        client.setEmail(clientDetails.getEmail());
        client.setCity(clientDetails.getCity());
        client.setAddress(clientDetails.getAddress());
        client.setCitizenship(clientDetails.getCitizenship());

        return clientRepository.save(client);
    }

    // Удалить клиента
    public void deleteClient(int id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Клиент с ID " + id + " не найден"));
        clientRepository.delete(client);
    }
}

