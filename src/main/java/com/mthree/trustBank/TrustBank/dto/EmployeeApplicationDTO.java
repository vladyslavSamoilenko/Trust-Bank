package com.mthree.trustBank.TrustBank.dto;

public class EmployeeApplicationDTO {
    private String username;
    private String accountType;

    // Default constructor
    public EmployeeApplicationDTO() {}

    // Parameterized constructor
    public EmployeeApplicationDTO( String username, String accountType) {
        this.username = username;
        this.accountType = accountType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "EmployeeApplicationAccountDTO{"+
                ", username='" + username + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
