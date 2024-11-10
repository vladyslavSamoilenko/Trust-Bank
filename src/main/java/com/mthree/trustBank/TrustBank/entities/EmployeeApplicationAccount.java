package com.mthree.trustBank.TrustBank.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees_application_accounts")
public class EmployeeApplicationAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employees_application_account")
    private int employeeAccountId;

    @Column(name = "username", length = 45, nullable = false)
    private String username;

    @Column(name = "password", length = 200, nullable = false)
    private String password;

    @Column(name = "account_type", length = 10)
    private String accountType;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id_employee")
    private Employee employee;

    // Геттеры и сеттеры
    public int getEmployeeAccountId() {
        return employeeAccountId;
    }

    public void setEmployeeAccountId(int employeeAccountId) {
        this.employeeAccountId = employeeAccountId;
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
