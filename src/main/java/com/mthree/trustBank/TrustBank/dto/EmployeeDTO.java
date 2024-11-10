package com.mthree.trustBank.TrustBank.dto;

public class EmployeeDTO {
    private int idEmployee;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;

    // Default constructor
    public EmployeeDTO() {}

    // Parameterized constructor
    public EmployeeDTO(int idEmployee, String firstName, String lastName, String telephoneNumber, String email) {
        this.idEmployee = idEmployee;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    // Getters and Setters
    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "idEmployee=" + idEmployee +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
