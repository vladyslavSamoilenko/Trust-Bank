package com.mthree.trustBank.TrustBank.dto;

import com.mthree.trustBank.TrustBank.entities.Employee;
import jakarta.persistence.*;

public class EmployeeApplicationDTO {
    private int idEmployeesApplicationAccount;
    private String username;
    private String password;
    private int employeeId;

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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
