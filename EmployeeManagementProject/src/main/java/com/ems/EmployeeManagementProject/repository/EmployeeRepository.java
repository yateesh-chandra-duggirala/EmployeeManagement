package com.ems.EmployeeManagementProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ems.EmployeeManagementProject.model.Employee;

/**
 * Interface Employee Repository.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * The Method to find the Employee with email Id.
     * @param emailId of String type queried.
     * @return the Employee if exists.
     */
    @Query("select emp from Employee as emp where emp.emailId = :emailId")
    Optional<Employee> findEmployeeByEmail(String emailId);
}
