package com.mthree.trustBank.TrustBank.controllers;

import com.mthree.trustBank.TrustBank.security.ClientAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final ClientAccountService clientAccountService;

    @Autowired
    public AdminController(ClientAccountService clientAccountService) {
        this.clientAccountService = clientAccountService;
    }

    // Показать форму для создания учетной записи клиента
    @GetMapping("/client_account_registration")
    public String showClientAccountRegistrationForm() {
        return "admin/html/client_account_registration";
    }

}

