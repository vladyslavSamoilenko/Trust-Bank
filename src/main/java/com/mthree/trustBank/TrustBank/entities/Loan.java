package com.mthree.trustBank.TrustBank.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loan")
    private int loanId;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private BankAccount account;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "loan_amount", precision = 15, scale = 2, nullable = false)
    private BigDecimal loanAmount;

    @Column(name = "interest_rate", precision = 5, scale = 2, nullable = false)
    private BigDecimal interestRate;

    @Column(name = "term", nullable = false)
    private int term;

    @Column(name = "interest_accured", precision = 15, scale = 2)
    private BigDecimal interestAccrued;

    // Геттеры и сеттеры
    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public BigDecimal getInterestAccrued() {
        return interestAccrued;
    }

    public void setInterestAccrued(BigDecimal interestAccrued) {
        this.interestAccrued = interestAccrued;
    }
}