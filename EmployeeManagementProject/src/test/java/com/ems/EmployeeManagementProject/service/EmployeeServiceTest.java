package com.ems.EmployeeManagementProject.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ems.EmployeeManagementProject.dto.EmployeeDTO;
import com.ems.EmployeeManagementProject.exception.AlreadyExistsException;
import com.ems.EmployeeManagementProject.exception.ElementNotExistsException;
import com.ems.EmployeeManagementProject.model.Employee;
import com.ems.EmployeeManagementProject.repository.EmployeeRepository;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee(2L, "Yateesh", "Chandra", "yateeshchandra@gmail.com");
        Employee employee2 = new Employee(3L, "Jaya", "Madhuri", "jayamadhuri@gmail.com");
        employees.add(employee1);
        employees.add(employee2);
        when(employeeRepository.findAll()).thenReturn(employees);

        List<EmployeeDTO> employeeDtos = employeeService.getAllEmployees();
        assertEquals(2, employeeDtos.size());
        assertEquals(employee1.getEmployeeId(), employeeDtos.get(0).getEmployeeId());
        assertEquals(employee1.getFirstName(), employeeDtos.get(0).getFirstName());
        assertEquals(employee1.getLastName(), employeeDtos.get(0).getLastName());
        assertEquals(employee1.getEmailId(), employeeDtos.get(0).getEmailId());

        assertEquals(employee2.getEmployeeId(), employeeDtos.get(1).getEmployeeId());
        assertEquals(employee2.getFirstName(), employeeDtos.get(1).getFirstName());
        assertEquals(employee2.getLastName(), employeeDtos.get(1).getLastName());
        assertEquals(employee2.getEmailId(), employeeDtos.get(1).getEmailId());
    }

    @Test
    void testAddEmployees() {
        EmployeeDTO employeeDto = new EmployeeDTO(2L, "Yateesh", "Chandra", "yateeshchandra@gmail.com");
        when(employeeRepository.findEmployeeByEmail(employeeDto.getEmailId())).thenReturn(Optional.empty());

        EmployeeDTO newEmployee = employeeService.addEmployee(employeeDto);
        assertEquals(employeeDto, newEmployee);
    }

    @Test
    void testAddEmployee_EmailAlreadyExists() {
        EmployeeDTO employeeDto = new EmployeeDTO(2L, "Yateesh", "Chandra", "yateeshchandra@gmail.com");
        when(employeeRepository.findEmployeeByEmail(employeeDto.getEmailId())).thenReturn(Optional.of(new Employee()));

        assertThrows(AlreadyExistsException.class, () -> employeeService.addEmployee(employeeDto));
    }

    @Test
    void testUpdateEmployee() {
        EmployeeDTO employeeDto = new EmployeeDTO(2L, "Yateesh", "Chandra", "yateeshchandra@gmail.com");
        Employee employee = new Employee(employeeDto.getEmployeeId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmailId());

        EmployeeDTO updatedemployeeDto = new EmployeeDTO(2L, "Yateesh", "Chandu", "yateeshchandu@gmail.com");
        Employee updatedEmployee = new Employee(updatedemployeeDto.getEmployeeId(), updatedemployeeDto.getFirstName(), updatedemployeeDto.getLastName(), updatedemployeeDto.getEmailId());

        when(employeeRepository.findById(updatedEmployee.getEmployeeId())).thenReturn(Optional.of(employee));
        when(employeeRepository.save(employee)).thenReturn(updatedEmployee);

        EmployeeDTO updatedEmployeeDto = employeeService.updateEmployee(2L, updatedemployeeDto);
        assertEquals(updatedEmployeeDto, updatedemployeeDto);
    }

    @Test
    void testUpdateEmployee_EmailAlreadyExists() {
        EmployeeDTO employeeDto = new EmployeeDTO(2L, "Yateesh", "Chandra", "yateeshchandra@gmail.com");
        Employee employee = new Employee(employeeDto.getEmployeeId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmailId());

        EmployeeDTO updatedemployeeDto = new EmployeeDTO(2L, "Yateesh", "Chandu", "yateeshchandra@gmail.com");
        Employee updatedEmployee = new Employee(updatedemployeeDto.getEmployeeId(), updatedemployeeDto.getFirstName(), updatedemployeeDto.getLastName(), updatedemployeeDto.getEmailId());

        when(employeeRepository.findById(updatedEmployee.getEmployeeId())).thenReturn(Optional.of(employee));
        when(employeeRepository.findEmployeeByEmail(updatedemployeeDto.getEmailId())).thenReturn(Optional.of(new Employee()));

        assertThrows(AlreadyExistsException.class, () -> employeeService.updateEmployee(2L, employeeDto));
    }

    @Test
    void deleteEmployee() {
        Employee employee = new Employee(1L, "Yateesh", "Chandra", "yateeshchandra@gmail.com");
        when(employeeRepository.findById(employee.getEmployeeId())).thenReturn(Optional.of(employee));
        assertDoesNotThrow(() -> employeeService.deleteEmployee(employee.getEmployeeId()));
    }

    @Test
    void deleteEmployee_IdnotExist() {
        Employee employee = new Employee(1L, "Yateesh", "Chandra", "yateeshchandra@gmail.com");
        when(employeeRepository.findById(employee.getEmployeeId())).thenReturn(Optional.empty());
        assertThrows(ElementNotExistsException.class, () -> employeeService.deleteEmployee(employee.getEmployeeId()));
    }

    @Test
    void getEmployeeById() {
        Employee employee = new Employee(1L, "yateesh", "Chandra", "yateeshchandra@gmail.com");
        when( employeeRepository.findById(employee.getEmployeeId())).thenReturn(Optional.of(employee));

        EmployeeDTO testEmployeeDto = new EmployeeDTO(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), employee.getEmailId());
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employee.getEmployeeId());
        assertEquals(employeeDTO, testEmployeeDto);
    }

    @Test
    void getEmployeeById_IdNotFound() {
        Employee employee = new Employee(1L, "yateesh", "Chandra", "yateeshchandra@gmail.com");
        when( employeeRepository.findById(employee.getEmployeeId())).thenReturn(Optional.empty());
        assertThrows(ElementNotExistsException.class, ()->employeeService.getEmployeeById(employee.getEmployeeId()));
    }
}
