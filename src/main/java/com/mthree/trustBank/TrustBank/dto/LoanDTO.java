package com.mthree.trustBank.TrustBank.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Date;

public class LoanDTO {

    @NotNull
    private int idLoan;
    @NotNull
    private int accountId;
    @NotNull
    private BigDecimal loanAmount;
    @NotNull
    private BigDecimal interestRate;
    @NotNull
    private Date term;
    @NotNull
    private BigDecimal interestAccrued;

    public int getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(int idLoan) {
        this.idLoan = idLoan;
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
}
