package com.mthree.trustBank.TrustBank.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class LoanDTO {
    private int clientId;
    private int accountId;
    private BigDecimal loanAmount;
    private BigDecimal interestRate;
    private Date term;
    private BigDecimal interestAccrued;

    // Default constructor
    public LoanDTO() {}

    // Parameterized constructor
    public LoanDTO(int clientId, int accountId, BigDecimal loanAmount, BigDecimal interestRate, Date term, BigDecimal interestAccrued) {
        this.clientId = clientId;
        this.accountId = accountId;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.term = term;
        this.interestAccrued = interestAccrued;
    }


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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

    public Date getTerm() {
        return term;
    }

    public void setTerm(Date term) {
        this.term = term;
    }

    public BigDecimal getInterestAccrued() {
        return interestAccrued;
    }

    public void setInterestAccrued(BigDecimal interestAccrued) {
        this.interestAccrued = interestAccrued;
    }

    @Override
    public String toString() {
        return "LoanDTO{" +
                "loanId=" +
                ", clientId=" + clientId +
                ", accountId=" + accountId +
                ", loanAmount=" + loanAmount +
                ", interestRate=" + interestRate +
                ", term=" + term +
                ", interestAccrued=" + interestAccrued +
                '}';
    }
}
