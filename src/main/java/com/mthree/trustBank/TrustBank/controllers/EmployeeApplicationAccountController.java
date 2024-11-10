package com.mthree.trustBank.TrustBank.controllers;

import com.mthree.trustBank.TrustBank.entities.EmployeeApplicationAccount;
import com.mthree.trustBank.TrustBank.services.EmployeeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees/accounts")
public class EmployeeApplicationAccountController {

    private final EmployeeAccountService employeesApplicationAccountService;

    @Autowired
    public EmployeeApplicationAccountController(EmployeeAccountService employeesApplicationAccountService) {
        this.employeesApplicationAccountService = employeesApplicationAccountService;
    }

    @PostMapping("/employee/{employeeId}")
    public ResponseEntity<EmployeeApplicationAccount> createAccountForEmployee(
            @PathVariable int employeeId, @RequestBody EmployeeApplicationAccount account) {
        return new ResponseEntity<>(employeesApplicationAccountService.createAccountForEmployee(employeeId, account), HttpStatus.CREATED);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<EmployeeApplicationAccount> getAccountByEmployeeId(@PathVariable int employeeId) {
        return new ResponseEntity<>(employeesApplicationAccountService.getAccountByEmployeeId(employeeId), HttpStatus.OK);
    }
}
