package com.ems.EmployeeManagementProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.EmployeeManagementProject.dto.EmployeeDTO;
import com.ems.EmployeeManagementProject.response.Response;
import com.ems.EmployeeManagementProject.response.ResponseMessages;
import com.ems.EmployeeManagementProject.service.EmployeeService;

import jakarta.validation.Valid;

/**
 * This is the Controller class.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@RestController
@CrossOrigin
@RequestMapping("employee")
public class EmployeeController {

    /**
     * Dependency Injection for Service.
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * Response Method for get All Employees.
     *
     * @return the response for the request with body.
     */
    @GetMapping
    public final Response getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        Response response = new Response(HttpStatus.OK.value(),
                ResponseMessages.FETCH_SUCCESS, employees);
        return response;
    }

    /**
     * This is the Response Method for adding Employees.
     * @param employeeDto of Employee DTO type.
     * @return the Response for the request
     */
    @PostMapping
    public final Response addEmployees(
            @RequestBody @Valid final EmployeeDTO employeeDto) {
        employeeService.addEmployee(employeeDto);
        Response response = new Response(HttpStatus.OK.value(),
                ResponseMessages.ADD_SUCCESS);
        return response;
    }

    /**
     * This is the Response for delete Employee method.
     * @param employeeId of Long type.
     * @return the Response for the request.
     */
    @DeleteMapping("/{employeeId}")
    public final Response deleteEmployee(@PathVariable final Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        Response response = new Response(HttpStatus.OK.value(),
                ResponseMessages.DELETE_SUCCESS);
        return response;
    }

    /**
     * This is the Response for getting employee by Id.
     * @param employeeId of Long type.
     * @return the Response with Body.
     */
    @GetMapping("/{employeeId}")
    public final Response getEmployeeById(@PathVariable final Long employeeId) {
        EmployeeDTO employeeDto = employeeService.getEmployeeById(employeeId);
        Response response = new Response(HttpStatus.OK.value(),
                ResponseMessages.FETCH_SUCCESS, employeeDto);
        return response;
    }

    /**
     * This is the  method to update employee.
     * @param employeeId of Long type as path Variable.
     * @param employeeDto of EmployeeDTO.
     * @return the response.
     */
    @PutMapping("/{employeeId}")
    public final Response updateEmployee(@PathVariable final Long employeeId,
            @RequestBody @Valid final EmployeeDTO employeeDto) {
        employeeService.updateEmployee(employeeId, employeeDto);
        Response response = new Response(HttpStatus.OK.value(),
                ResponseMessages.UPDATE_SUCCESS);
        return response;
    }
}
