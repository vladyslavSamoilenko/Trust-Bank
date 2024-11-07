package com.mthree.trustBank.TrustBank.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees_application_account")
public class Employee {
    @Setter
    @Getter
    @Id
    @Column(name = "id_employees_application_account")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Email
    @NotEmpty(message = "Email cannot be empty")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "Password cannot be empty")
    @Column(name = "password")
    private String password;

    @Getter
    @Setter
    private int accountType = 2;

    public @Email @NotEmpty(message = "Email cannot be empty") String getUsername() {
        return username;
    }

    public void setEmail(@Email @NotEmpty(message = "Email cannot be empty") String email) {
        this.username = username;
    }

    public @NotEmpty(message = "Password cannot be empty") String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty(message = "Password cannot be empty") String password) {
        this.password = password;
    }

}
