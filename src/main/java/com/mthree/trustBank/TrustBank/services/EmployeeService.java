package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.dto.EmployeeDTO;
import com.mthree.trustBank.TrustBank.entities.Employee;
import com.mthree.trustBank.TrustBank.entities.EmployeeApplicationAccount;
import com.mthree.trustBank.TrustBank.repositories.ClientAccountRepository;
import com.mthree.trustBank.TrustBank.repositories.ClientRepository;
import com.mthree.trustBank.TrustBank.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return convertToDTO(employee);
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = convertToEntity(employeeDTO);
        employee = employeeRepository.save(employee);
        return convertToDTO(employee);
    }

    public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        existingEmployee.setFirstName(employeeDTO.getFirstName());
        existingEmployee.setLastName(employeeDTO.getLastName());
        // Update other fields as necessary
        existingEmployee = employeeRepository.save(existingEmployee);
        return convertToDTO(existingEmployee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    private EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setIdEmployee(employee.getIdEmployee());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setTelephoneNumber(employee.getTelephoneNumber()); // Ensure this is included
        dto.setEmail(employee.getEmail());
        return dto;
    }

    private Employee convertToEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());              // Add this line
        employee.setTelephoneNumber(dto.getTelephoneNumber()); // Add this line
        return employee;
    }
}
