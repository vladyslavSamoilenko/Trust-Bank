package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.dto.EmployeeApplicationDTO;
import com.mthree.trustBank.TrustBank.entities.Employee;
import com.mthree.trustBank.TrustBank.entities.EmployeeApplicationAccount;
import com.mthree.trustBank.TrustBank.repositories.EmployeeAccountRepository;
import com.mthree.trustBank.TrustBank.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeApplicationAccountService {

    private final EmployeeAccountRepository employeeApplicationAccountRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeApplicationAccountService(EmployeeAccountRepository employeeApplicationAccountRepository,
                                             EmployeeRepository employeeRepository) {
        this.employeeApplicationAccountRepository = employeeApplicationAccountRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeApplicationDTO> getAllEmployeeApplicationAccounts() {
        return employeeApplicationAccountRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public EmployeeApplicationDTO getEmployeeApplicationAccountById(int id) {
        EmployeeApplicationAccount account = employeeApplicationAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee application account not found"));
        return convertToDTO(account);
    }

    public EmployeeApplicationDTO createEmployeeApplicationAccount(EmployeeApplicationDTO dto) {
        EmployeeApplicationAccount account = convertToEntity(dto);
        account = employeeApplicationAccountRepository.save(account);
        return convertToDTO(account);
    }

    public EmployeeApplicationDTO updateEmployeeApplicationAccount(int id, EmployeeApplicationDTO dto) {
        EmployeeApplicationAccount existingAccount = employeeApplicationAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee application account not found"));
        existingAccount.setUsername(dto.getUsername());
        existingAccount.setPassword(dto.getPassword());
        existingAccount = employeeApplicationAccountRepository.save(existingAccount);
        return convertToDTO(existingAccount);
    }

    public void deleteEmployeeApplicationAccount(int id) {
        employeeApplicationAccountRepository.deleteById(id);
    }

    private EmployeeApplicationDTO convertToDTO(EmployeeApplicationAccount account) {
        EmployeeApplicationDTO dto = new EmployeeApplicationDTO();
        dto.setIdEmployeesApplicationAccount(account.getIdEmployeesApplicationAccount());
        dto.setUsername(account.getUsername());
        dto.setPassword(account.getPassword());
        return dto;
    }

    private EmployeeApplicationAccount convertToEntity(EmployeeApplicationDTO dto) {
        EmployeeApplicationAccount account = new EmployeeApplicationAccount();
        Employee employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        account.setEmployee(employee);
        account.setUsername(dto.getUsername());
        account.setPassword(dto.getPassword());
        return account;
    }
    public EmployeeApplicationDTO authenticateEmployee(String username, String password) {
        return employeeApplicationAccountRepository.findByUsernameAndPassword(username, password)
                .map(this::convertToDTO)
                .orElse(null);
    }
}