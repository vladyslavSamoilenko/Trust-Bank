package com.mthree.trustBank.TrustBank.controllers;

import com.mthree.trustBank.TrustBank.dto.EmployeeApplicationDTO;
import com.mthree.trustBank.TrustBank.services.EmployeeApplicationAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeeApplicationAccounts")
public class EmployeeApplicationAccountController {

    @Autowired
    private EmployeeApplicationAccountService employeeApplicationAccountService;

    @GetMapping
    public List<EmployeeApplicationDTO> getAllEmployeeApplicationAccounts() {
        return employeeApplicationAccountService.getAllEmployeeApplicationAccounts();
    }

    @GetMapping("/{id}")
    public EmployeeApplicationDTO getEmployeeApplicationAccountById(@PathVariable int id) {
        return employeeApplicationAccountService.getEmployeeApplicationAccountById(id);
    }

    @PostMapping
    public EmployeeApplicationDTO createEmployeeApplicationAccount(@RequestBody EmployeeApplicationDTO dto) {
        return employeeApplicationAccountService.createEmployeeApplicationAccount(dto);
    }

    @PutMapping("/{id}")
    public EmployeeApplicationDTO updateEmployeeApplicationAccount(@PathVariable int id, @RequestBody EmployeeApplicationDTO dto) {
        return employeeApplicationAccountService.updateEmployeeApplicationAccount(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeApplicationAccount(@PathVariable int id) {
        employeeApplicationAccountService.deleteEmployeeApplicationAccount(id);
    }
}
