package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.entities.Client;
import com.mthree.trustBank.TrustBank.entities.Loan;
import com.mthree.trustBank.TrustBank.repositories.ClientRepository;
import com.mthree.trustBank.TrustBank.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository, ClientRepository clientRepository) {
        this.loanRepository = loanRepository;
        this.clientRepository = clientRepository;
    }

    // Получить все кредиты
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    // Найти кредит по ID
    public Loan getLoanById(int id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Кредит с ID " + id + " не найден"));
    }

    // Создать новый кредит для клиента
    public Loan createLoan(int clientId, Loan loan) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Клиент с ID " + clientId + " не найден"));
        loan.setClient(client);
        return loanRepository.save(loan);
    }

    // Удалить кредит
    public void deleteLoan(int id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Кредит с ID " + id + " не найден"));
        loanRepository.delete(loan);
    }
}
