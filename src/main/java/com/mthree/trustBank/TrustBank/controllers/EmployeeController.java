package com.mthree.trustBank.TrustBank.controllers;

import com.mthree.trustBank.TrustBank.entities.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class EmployeeController {

    @GetMapping("/login_employee")
    public String loginPage(){
        return "auth/html/loginEmployee";
    }

    @GetMapping("/dashboard")
    public String showDashboard(){
        return "employee/html/dashboard";
    }

    @GetMapping("/client_registration")
    public String clientAccountRegistration(){
        return "employee/html/client_registration";
    }
}
