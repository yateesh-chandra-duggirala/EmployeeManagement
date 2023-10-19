package com.ems.EmployeeManagementProject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.EmployeeManagementProject.dto.EmployeeDTO;
import com.ems.EmployeeManagementProject.exception.AlreadyExistsException;
import com.ems.EmployeeManagementProject.exception.ElementNotExistsException;
import com.ems.EmployeeManagementProject.model.Employee;
import com.ems.EmployeeManagementProject.repository.EmployeeRepository;
import com.ems.EmployeeManagementProject.response.ErrorMessages;

/**
 * This is the Service class.
 */
@Service
public class EmployeeService {

    /**
     * Dependency injection to Repository.
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * This is the method to get all Employees.
     *
     * @return the list of Employees.
     */
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employee = employeeRepository.findAll();
        return employee.stream().map(this::convertModeltoDto)
                .collect(Collectors.toList());
    }

    /**
     * This method converts the Model to DTO.
     *
     * @param employee of Employee type.
     * @return the DTO form of model.
     */
    public EmployeeDTO convertModeltoDto(final Employee employee) {
        EmployeeDTO employeeDto = new EmployeeDTO();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmailId(employee.getEmailId());
        return employeeDto;
    }

    /**
     * This is the Method to add employees.
     *
     * @param employeedto of EmployeeDTO type.
     * @return the Employee DTO.
     */
    public EmployeeDTO addEmployee(final EmployeeDTO employeedto) {
        Optional<Employee> employee = employeeRepository
                .findEmployeeByEmail(employeedto.getEmailId());
        if (employee.isPresent()) {
            throw new AlreadyExistsException(ErrorMessages.EMPLOYEE_EXISTS);
        }
        Employee newEmployee = new Employee();
        newEmployee.setEmployeeId(employeedto.getEmployeeId());
        newEmployee.setFirstName(employeedto.getFirstName());
        newEmployee.setLastName(employeedto.getLastName());
        newEmployee.setEmailId(employeedto.getEmailId());
        employeeRepository.save(newEmployee);
        return employeedto;
    }

    /**
     * This method deletes the Employee by his Id.
     *
     * @param employeeId of Long type.
     */
    public void deleteEmployee(final Long employeeId) {
        employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ElementNotExistsException(
                        ErrorMessages.EMPLOYEE_NOTFOUND + employeeId));
        employeeRepository.deleteById(employeeId);
    }

    /**
     * This returns the employee with ID.
     * @param employeeId of Long type.
     * @return the EmployeeDTO.
     */
    public EmployeeDTO getEmployeeById(final Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ElementNotExistsException(
                        ErrorMessages.EMPLOYEE_NOTFOUND + employeeId));
        EmployeeDTO employeeDto = new EmployeeDTO();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmailId(employee.getEmailId());
        return employeeDto;
    }

    /**
     * This method updates the Employee.
     * @param employeeId of Long type.
     * @param updatedEmployeeDto of Long type.
     * @return the EmployeeDTO that is updated.
     */
    public EmployeeDTO updateEmployee(final Long employeeId,
            final EmployeeDTO updatedEmployeeDto) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ElementNotExistsException(
                        ErrorMessages.EMPLOYEE_NOTFOUND));
        Optional<Employee> emp = employeeRepository
                .findEmployeeByEmail(updatedEmployeeDto.getEmailId());
        if (emp.isPresent()) {
            throw new AlreadyExistsException(ErrorMessages.EMPLOYEE_EXISTS);
        }
        employee.setFirstName(updatedEmployeeDto.getFirstName());
        employee.setLastName(updatedEmployeeDto.getLastName());
        employee.setEmailId(updatedEmployeeDto.getEmailId());

        Employee newEmployee = employeeRepository.save(employee);
        EmployeeDTO employeeDto = new EmployeeDTO();
        employeeDto.setEmployeeId(newEmployee.getEmployeeId());
        employeeDto.setFirstName(newEmployee.getFirstName());
        employeeDto.setLastName(newEmployee.getLastName());
        employeeDto.setEmailId(newEmployee.getEmailId());
        return employeeDto;
    }
}
