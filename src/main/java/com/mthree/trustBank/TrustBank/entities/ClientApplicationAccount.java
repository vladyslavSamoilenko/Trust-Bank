package com.mthree.trustBank.TrustBank.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clients_application_accounts")
public class ClientApplicationAccount {

    @Id
    private int idClient;

    @Column(nullable = false, length = 45, unique = true)
    private String username;

    @Column(nullable = false, length = 200)
    private String password;

    @OneToOne
    @JoinColumn(name = "id_client", referencedColumnName = "clientId")
    private Client client;

    // Getters and Setters

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
