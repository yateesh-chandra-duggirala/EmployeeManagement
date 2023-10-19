package com.ems.EmployeeManagementProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is the Employee entity.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {

    /**
     * This is the Employee Id field.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    /**
     * This is the First Name field.
     */
    @Column(nullable = false)
    private String firstName;

    /**
     * This is the Last Name field.
     */
    @Column(nullable = false)
    private String lastName;

    /**
     * This is the email Id field.
     */
    @Column(nullable = false, unique = true)
    private String emailId;

}
