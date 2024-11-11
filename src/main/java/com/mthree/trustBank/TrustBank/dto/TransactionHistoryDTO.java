package com.mthree.trustBank.TrustBank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Date;

public class TransactionHistoryDTO {
    private int transactionId;

    @NotNull(message = "Account ID is mandatory")
    private int accountId;

    @NotNull(message = "To Account ID is mandatory")
    private int toAccountId;

    @NotNull(message = "Amount is mandatory")
    private BigDecimal amount;

    @NotBlank(message = "Transaction type is mandatory")
    private String transactionType;

    @NotNull(message = "Transaction time is mandatory")
    private Date transactionTime;

    @NotBlank(message = "Description is mandatory")
    private String description;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(int toAccountId) {
        this.toAccountId = toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
