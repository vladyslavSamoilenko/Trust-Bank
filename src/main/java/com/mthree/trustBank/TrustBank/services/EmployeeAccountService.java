package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.entities.Employee;
import com.mthree.trustBank.TrustBank.entities.EmployeeApplicationAccount;
import com.mthree.trustBank.TrustBank.repositories.EmployeeAccountRepository;
import com.mthree.trustBank.TrustBank.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeAccountService {

    private final EmployeeAccountRepository employeesApplicationAccountRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeAccountService(EmployeeAccountRepository employeesApplicationAccountRepository,
                                              EmployeeRepository employeeRepository) {
        this.employeesApplicationAccountRepository = employeesApplicationAccountRepository;
        this.employeeRepository = employeeRepository;
    }

    public EmployeeApplicationAccount createAccountForEmployee(int employeeId, EmployeeApplicationAccount account) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Сотрудник с ID " + employeeId + " не найден"));
        account.setEmployee(employee);
        return employeesApplicationAccountRepository.save(account);
    }

    public EmployeeApplicationAccount getAccountByEmployeeId(int employeeId) {
        return employeesApplicationAccountRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Учетная запись сотрудника с ID " + employeeId + " не найдена"));
    }
}
