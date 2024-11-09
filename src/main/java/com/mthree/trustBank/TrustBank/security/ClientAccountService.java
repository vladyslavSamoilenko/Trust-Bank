package com.mthree.trustBank.TrustBank.security;

import com.mthree.trustBank.TrustBank.dto.ClientAccountDTO;
import com.mthree.trustBank.TrustBank.entities.ClientApplicationAccount;
import com.mthree.trustBank.TrustBank.repositories.ClientAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientAccountService {
    private final ClientAccountRepository clientAccountRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ClientAccountService(ClientAccountRepository clientAccountRepository, PasswordEncoder passwordEncoder) {
        this.clientAccountRepository = clientAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ClientApplicationAccount createClientAccount(ClientAccountDTO clientAccountDTO) {
        ClientApplicationAccount clientApplicationAccount = new ClientApplicationAccount();
        clientApplicationAccount.setId(clientAccountDTO.getClientId());
        clientApplicationAccount.setUsername(clientAccountDTO.getUsername());
        clientApplicationAccount.setPassword(passwordEncoder.encode(clientAccountDTO.getPassword()));
        return clientAccountRepository.save(clientApplicationAccount);
    }
}
