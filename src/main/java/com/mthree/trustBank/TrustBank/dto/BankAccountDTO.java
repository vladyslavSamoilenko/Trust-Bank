package com.mthree.trustBank.TrustBank.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Date;

public class BankAccountDTO {
    private int accountId;
    private int clientId;
    private int accountType;
    private BigDecimal balance;
    private Date openedDate;
    private int clientType;
    private String accountNumber;

    // Default constructor
    public BankAccountDTO() {}

    // Parameterized constructor
    public BankAccountDTO(int accountId, int clientId, int accountType, BigDecimal balance, Date openedDate, int clientType, String accountNumber) {
        this.accountId = accountId;
        this.clientId = clientId;
        this.accountType = accountType;
        this.balance = balance;
        this.openedDate = openedDate;
        this.clientType = clientType;
        this.accountNumber = accountNumber;
    }

    // Getters and Setters
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(Date openedDate) {
        this.openedDate = openedDate;
    }

    public int getClientType() {
        return clientType;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "BankAccountDTO{" +
                "accountId=" + accountId +
                ", clientId=" + clientId +
                ", accountType=" + accountType +
                ", balance=" + balance +
                ", openedDate=" + openedDate +
                ", clientType=" + clientType +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
