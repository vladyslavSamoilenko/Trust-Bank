package com.mthree.trustBank.TrustBank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/choise")
    public String home() {
        return "login_choise";
    }

    @GetMapping("/login_client")
    public String loginClient(){
        return "client_login";
    }

    @GetMapping("/client_dashboard")
    public String clientDashboard() {
        return "client_dashboard";
    }

    @GetMapping("/login_employee")
    public String loginEmployee(){
        return "employee_login";
    }
    @GetMapping("/employee_dashboard")
    public String employeeDashboard() {
        return "employee_dashboard";
    }
}
