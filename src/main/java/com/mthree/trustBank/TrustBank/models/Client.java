package com.mthree.trustBank.TrustBank.models;


import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "client_id")
    @GeneratedValue
    private String id;

}
