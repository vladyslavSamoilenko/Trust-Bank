package com.mthree.trustBank.TrustBank.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Date;

public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;

    @NotNull
    @Column(name = "client_id")
    private int clientId;

    @NotNull
    @Column(name = "account_type")
    private int accountType;

    @NotNull
    @Column(name = "balance", precision = 10, scale = 2)
    private BigDecimal balance;

    @NotNull
    @Column(name = "opened_date")
    private Date openedDate;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @NotNull
    public int getClientId() {
        return clientId;
    }

    public void setClientId(@NotNull int clientId) {
        this.clientId = clientId;
    }

    @NotNull
    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(@NotNull int accountType) {
        this.accountType = accountType;
    }

    public @NotNull BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(@NotNull BigDecimal balance) {
        this.balance = balance;
    }

    public @NotNull Date getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(@NotNull Date openedDate) {
        this.openedDate = openedDate;
    }

    @NotNull
    public int getClientType() {
        return clientType;
    }

    public void setClientType(@NotNull int clientType) {
        this.clientType = clientType;
    }

    public @NotNull String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(@NotNull String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @NotNull
    @Column(name = "client_type")
    private int clientType;

    @NotNull
    @Column(name = "account_number", length = 26)
    private String accountNumber;

}
