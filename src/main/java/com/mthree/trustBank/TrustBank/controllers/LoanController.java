package com.mthree.trustBank.TrustBank.controllers;

import com.mthree.trustBank.TrustBank.dto.LoanDTO;
import com.mthree.trustBank.TrustBank.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    public List<LoanDTO> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}")
    public LoanDTO getLoanById(@PathVariable int id) {
        return loanService.getLoanById(id);
    }

    @PostMapping
    public LoanDTO createLoan(@RequestBody LoanDTO loanDTO) {
        return loanService.createLoan(loanDTO);
    }

    @PutMapping("/{id}")
    public LoanDTO updateLoan(@PathVariable int id, @RequestBody LoanDTO loanDTO) {
        return loanService.updateLoan(id, loanDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable int id) {
        loanService.deleteLoan(id);
    }
}
