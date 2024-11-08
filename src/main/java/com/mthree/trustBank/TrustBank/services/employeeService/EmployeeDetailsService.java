package com.mthree.trustBank.TrustBank.services.employeeService;

import com.mthree.trustBank.TrustBank.entities.EmployeeApplicationAccount;
import com.mthree.trustBank.TrustBank.repositories.EmployeeRepository;
import com.mthree.trustBank.TrustBank.security.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<EmployeeApplicationAccount> employee = employeeRepository.findByUsername(username);
        if (employee.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        return new EmployeeDetails(employee.get());
    }
}
