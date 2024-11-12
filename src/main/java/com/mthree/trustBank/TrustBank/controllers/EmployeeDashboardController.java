package com.mthree.trustBank.TrustBank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeDashboardController {
    @GetMapping("/employee-dashboard")
    public String showEmployeeDashboard() {
        return "employee_dashboard"; // No need for ".html" extension, Thymeleaf will find it
    }
}
