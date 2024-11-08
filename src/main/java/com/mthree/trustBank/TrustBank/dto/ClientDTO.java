package com.mthree.trustBank.TrustBank.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

public class ClientDTO {

    @NotEmpty(message = "First name cannot be empty")
    private String first_name;

    @NotEmpty(message = "Last name cannot be empty")
    private String last_name;

    @NotEmpty
    private Date date_of_birthday;

    @NotEmpty(message = "Phone number cannot be empty")
    private String phone;

    @NotEmpty(message = "Email cannot be empty")
    @Email
    private String email;

    @NotEmpty(message = "City cannot be empty")
    private String city;

    @NotEmpty(message = "Address cannot be empty")
    private String address;

    @NotEmpty(message = "Citizenship cannot be empty")
    private String citizenship;

    public @NotEmpty(message = "First name cannot be empty") String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(@NotEmpty(message = "First name cannot be empty") String first_name) {
        this.first_name = first_name;
    }

    public @NotEmpty(message = "Last name cannot be empty") String getLast_name() {
        return last_name;
    }

    public void setLast_name(@NotEmpty(message = "Last name cannot be empty") String last_name) {
        this.last_name = last_name;
    }

    public @NotEmpty Date getDate_of_birthday() {
        return date_of_birthday;
    }

    public void setDate_of_birthday(@NotEmpty Date date_of_birthday) {
        this.date_of_birthday = date_of_birthday;
    }

    public @NotEmpty(message = "Phone number cannot be empty") String getPhone() {
        return phone;
    }

    public void setPhone(@NotEmpty(message = "Phone number cannot be empty") String phone) {
        this.phone = phone;
    }

    public @NotEmpty(message = "Email cannot be empty") @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "Email cannot be empty") @Email String email) {
        this.email = email;
    }

    public @NotEmpty(message = "City cannot be empty") String getCity() {
        return city;
    }

    public void setCity(@NotEmpty(message = "City cannot be empty") String city) {
        this.city = city;
    }

    public @NotEmpty(message = "Address cannot be empty") String getAddress() {
        return address;
    }

    public void setAddress(@NotEmpty(message = "Address cannot be empty") String address) {
        this.address = address;
    }

    public @NotEmpty(message = "Citizenship cannot be empty") String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(@NotEmpty(message = "Citizenship cannot be empty") String citizenship) {
        this.citizenship = citizenship;
    }
}
