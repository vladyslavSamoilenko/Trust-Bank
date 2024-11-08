package com.mthree.trustBank.TrustBank.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private int id_employee;

    @Column(name = "first_name")
    @NotEmpty(message = "First name cannot be empty")
    private String first_name;

    @Column(name = "last_name")
    @NotEmpty(message = "Last name cannot be empty")
    private String last_name;

    @Column(name = "telephone_number")
    @NotEmpty(message = "Telephone number cannot be empty")
    private String telephone_number;

    @Email
    @Column(name = "email")
    @NotEmpty(message = "Email name cannot be empty")
    private String email;
}
