package com.mthree.trustBank.TrustBank.repositories;

import com.mthree.trustBank.TrustBank.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Employee, Integer> {
}
