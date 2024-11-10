package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.entities.Employee;
import com.mthree.trustBank.TrustBank.entities.EmployeeApplicationAccount;
import com.mthree.trustBank.TrustBank.repositories.ClientAccountRepository;
import com.mthree.trustBank.TrustBank.repositories.ClientRepository;
import com.mthree.trustBank.TrustBank.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Сотрудник с ID " + id + " не найден"));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }
}
