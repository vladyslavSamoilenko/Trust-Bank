package com.mthree.trustBank.TrustBank.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees_application_account")
public class EmployeeApplicationAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmployeesApplicationAccount;

    @Column(nullable = false, length = 45, unique = true)
    private String username;

    @Column(nullable = false, length = 200)
    private String password;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = true)
    private Employee employee;

    // Getters and Setters

    public int getIdEmployeesApplicationAccount() {
        return idEmployeesApplicationAccount;
    }

    public void setIdEmployeesApplicationAccount(int idEmployeesApplicationAccount) {
        this.idEmployeesApplicationAccount = idEmployeesApplicationAccount;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
