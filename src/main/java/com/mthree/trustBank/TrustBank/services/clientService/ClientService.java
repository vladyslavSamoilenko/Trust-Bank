package com.mthree.trustBank.TrustBank.services.clientService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ClientService {
}
