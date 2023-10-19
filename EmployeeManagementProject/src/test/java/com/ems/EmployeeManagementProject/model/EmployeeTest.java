package com.ems.EmployeeManagementProject.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest {

    @Test
    void testGettersAndSetters() {
        Employee employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setFirstName("Yateesh");
        employee.setLastName("Chandra");
        employee.setEmailId("yateeshchandra@gmail.com");
        assertEquals(1L, employee.getEmployeeId());
        assertEquals("Yateesh", employee.getFirstName());
        assertEquals("Chandra", employee.getLastName());
        assertEquals("yateeshchandra@gmail.com", employee.getEmailId());
    }

    @Test
    void testAllArgsConstructor() {
        Employee employee = new Employee(1L, "Yateesh", "Chandra", "yateeshchandra@gmail.com");
        assertEquals(employee.getEmployeeId(),1L);
        assertEquals(employee.getFirstName(), "Yateesh");
        assertEquals(employee.getLastName(), "Chandra");
        assertEquals(employee.getEmailId(), "yateeshchandra@gmail.com");
    }

    @Test
    void testNoArgsConstructor() {
        Employee employee = new Employee();
        assertNull(employee.getEmployeeId());
        assertNull(employee.getFirstName());
        assertNull(employee.getLastName());
        assertNull(employee.getEmployeeId());
    }
}
