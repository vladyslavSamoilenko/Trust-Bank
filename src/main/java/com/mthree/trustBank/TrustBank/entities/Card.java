package com.mthree.trustBank.TrustBank.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;

@Entity
@Table(name = "cards")
public class Card{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private int cardId;

    @NotNull
    @Column(name = "client_id")
    private int clientId;

    @NotNull
    @Column(name = "account_id")
    private int accountId;

    @NotNull
    @Size(min = 16, max = 16)
    @Column(name = "card_number", length = 16)
    private String cardNumber;

    @NotNull
    @Column(name = "card_type")
    private int cardType;

    @NotNull
    @Column(name = "expiration_date")
    private Date expirationDate;

    @NotNull
    @Column(name = "cvv")
    private byte[] cvv;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @NotNull
    public int getClientId() {
        return clientId;
    }

    public void setClientId(@NotNull int clientId) {
        this.clientId = clientId;
    }

    @NotNull
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(@NotNull int accountId) {
        this.accountId = accountId;
    }

    public @NotNull @Size(min = 16, max = 16) String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(@NotNull @Size(min = 16, max = 16) String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @NotNull
    public int getCardType() {
        return cardType;
    }

    public void setCardType(@NotNull int cardType) {
        this.cardType = cardType;
    }

    public @NotNull Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(@NotNull Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @NotNull
    public byte[] getCvv() {
        return cvv;
    }

    public void setCvv(@NotNull byte[] cvv) {
        this.cvv = cvv;
    }
}

