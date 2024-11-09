package com.mthree.trustBank.TrustBank.services.clientService;

import com.mthree.trustBank.TrustBank.dto.ClientDTO;
import com.mthree.trustBank.TrustBank.entities.Client;
import com.mthree.trustBank.TrustBank.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create(ClientDTO clientDTO){
        Client client = new Client();
        client.setFirst_name(clientDTO.getFirst_name());
        client.setLast_name(clientDTO.getLast_name());
        client.setDate_of_birthday(clientDTO.getDate_of_birthday());
        client.setPhone(clientDTO.getPhone());
        client.setEmail(clientDTO.getEmail());
        client.setCity(clientDTO.getCity());
        client.setAddress(clientDTO.getAddress());
        client.setCitizenship(clientDTO.getCitizenship());
        return clientRepository.save(client);
    }
}
