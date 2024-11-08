package com.mthree.trustBank.TrustBank.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "First name cannot be empty")
    @Column(name = "first_name")
    private String first_name;

    @NotEmpty(message = "Last name cannot be empty")
    @Column(name = "last_name")
    private String last_name;

    @Column(name = "date_of_birthday")
    private Date date_of_birthday;

    @NotEmpty(message = "Phone number cannot be empty")
    @Column(name = "phone")
    private String phone;

    @NotEmpty(message = "Email cannot be empty")
    @Column(name = "email")
    @Email
    private String email;

    @NotEmpty(message = "City cannot be empty")
    @Column(name = "city")
    private String city;

    @NotEmpty(message = "Address cannot be empty")
    @Column(name = "address")
    private String address;

    @NotEmpty(message = "Citizenship cannot be empty")
    @Column(name = "citizenship")
    private String citizenship;
}
