package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.dto.EmployeeDTO;
import com.mthree.trustBank.TrustBank.entities.Employee;
import com.mthree.trustBank.TrustBank.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.mthree.trustBank.TrustBank.dto.EmployeeDTO;
import com.mthree.trustBank.TrustBank.entities.Employee;
import com.mthree.trustBank.TrustBank.repositories.EmployeeRepository;
import com.mthree.trustBank.TrustBank.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEmployeeById_Success() {
        Employee employee = new Employee();
        employee.setIdEmployee(1);
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmail("john.doe@example.com");

        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        EmployeeDTO result = employeeService.getEmployeeById(1);

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
    }

    @Test
    void testGetEmployeeById_NotFound() {
        when(employeeRepository.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            employeeService.getEmployeeById(1);
        });

        assertEquals("Employee not found", exception.getMessage());
    }

    @Test
    void testCreateEmployee() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName("Alice");
        employeeDTO.setLastName("Johnson");
        employeeDTO.setEmail("alice.johnson@example.com");

        Employee employee = new Employee();
        employee.setFirstName("Alice");
        employee.setLastName("Johnson");
        employee.setEmail("alice.johnson@example.com");

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        EmployeeDTO result = employeeService.createEmployee(employeeDTO);

        assertNotNull(result);
        assertEquals("Alice", result.getFirstName());
    }
}
