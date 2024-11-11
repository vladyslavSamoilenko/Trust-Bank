package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.dto.LoanDTO;
import com.mthree.trustBank.TrustBank.entities.Account;
import com.mthree.trustBank.TrustBank.entities.Client;
import com.mthree.trustBank.TrustBank.entities.Loan;
import com.mthree.trustBank.TrustBank.repositories.AccountRepository;
import com.mthree.trustBank.TrustBank.repositories.ClientRepository;
import com.mthree.trustBank.TrustBank.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final AccountRepository accountRepository;

    public LoanService(LoanRepository loanRepository, AccountRepository accountRepository) {
        this.loanRepository = loanRepository;
        this.accountRepository = accountRepository;
    }

    public List<LoanDTO> getAllLoans() {
        return loanRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public LoanDTO getLoanById(int id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
        return convertToDTO(loan);
    }

    public LoanDTO createLoan(LoanDTO loanDTO) {
        Loan loan = convertToEntity(loanDTO);
        loan = loanRepository.save(loan);
        return convertToDTO(loan);
    }

    public LoanDTO updateLoan(int id, LoanDTO loanDTO) {
        Loan existingLoan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
        existingLoan.setLoanAmount(loanDTO.getLoanAmount());
        // Update other fields as necessary
        existingLoan = loanRepository.save(existingLoan);
        return convertToDTO(existingLoan);
    }

    public void deleteLoan(int id) {
        loanRepository.deleteById(id);
    }

    private LoanDTO convertToDTO(Loan loan) {
        LoanDTO dto = new LoanDTO();
        dto.setIdLoan(loan.getIdLoan());
        dto.setAccountId(loan.getAccount().getAccountId());
        // Map other fields as necessary
        return dto;
    }

    private Loan convertToEntity(LoanDTO dto) {
        Loan loan = new Loan();
        Account account = accountRepository.findById(dto.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));
        loan.setAccount(account);
        loan.setLoanAmount(dto.getLoanAmount());
        return loan;
    }
}