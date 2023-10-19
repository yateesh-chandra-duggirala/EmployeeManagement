package com.ems.EmployeeManagementProject.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeDTOTest {
    @Test
    void testGettersAndSetters() {
        EmployeeDTO employeeDto = new EmployeeDTO();
        employeeDto.setEmployeeId(1L);
        employeeDto.setFirstName("Yateesh");
        employeeDto.setLastName("Chandra");
        employeeDto.setEmailId("yateeshchandra@gmail.com");
        assertEquals(1L, employeeDto.getEmployeeId());
        assertEquals("Yateesh", employeeDto.getFirstName());
        assertEquals("Chandra", employeeDto.getLastName());
        assertEquals("yateeshchandra@gmail.com", employeeDto.getEmailId());
    }

    @Test
    void testAllArgsConstructor() {
        EmployeeDTO employeeDto = new EmployeeDTO(1L, "Yateesh", "Chandra", "yateeshchandra@gmail.com");
        assertEquals(employeeDto.getEmployeeId(),1L);
        assertEquals(employeeDto.getFirstName(), "Yateesh");
        assertEquals(employeeDto.getLastName(), "Chandra");
        assertEquals(employeeDto.getEmailId(), "yateeshchandra@gmail.com");
    }

    @Test
    void testNoArgsConstructor() {
        EmployeeDTO employeeDto = new EmployeeDTO();
        assertNull(employeeDto.getEmployeeId());
        assertNull(employeeDto.getFirstName());
        assertNull(employeeDto.getLastName());
        assertNull(employeeDto.getEmployeeId());
    }
}
