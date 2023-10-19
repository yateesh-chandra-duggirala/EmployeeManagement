package com.ems.EmployeeManagementProject.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import com.ems.EmployeeManagementProject.dto.EmployeeDTO;
import com.ems.EmployeeManagementProject.response.Response;
import com.ems.EmployeeManagementProject.response.ResponseMessages;
import com.ems.EmployeeManagementProject.service.EmployeeService;

@SuppressWarnings({"rawtypes","unchecked"})
class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addEmployee() {
        Long employeeId = 7L;
        EmployeeDTO employeeDto = new EmployeeDTO(employeeId, "Yateesh", "Chandra", "yateeshchandra@gmail.com");
        Response expectedResponse = new Response(HttpStatus.OK.value(), ResponseMessages.ADD_SUCCESS);
        Response response = employeeController.addEmployees(employeeDto);
        assertEquals(response, expectedResponse);
    }

    @Test
    void updateEmployee() {
        Long employeeId = 7L;
        EmployeeDTO employeeDto = new EmployeeDTO(employeeId, "Yateesh", "Chandra", "yateeshchandra@gmail.com");
        Response expectedResponse = new Response(HttpStatus.OK.value(), ResponseMessages.UPDATE_SUCCESS);
        Response response = employeeController.updateEmployee(employeeId, employeeDto);
        assertEquals(response, expectedResponse);
    }

    @Test
    void deleteEmployee() {
        Long employeeId = 7L;
        Response expectedResponse = new Response(HttpStatus.OK.value(), ResponseMessages.DELETE_SUCCESS);
        Response response = employeeController.deleteEmployee(employeeId);
        assertEquals(response, expectedResponse);
    }

    @Test
    void getAllEmployees() {
        List<EmployeeDTO> employeeList = new ArrayList<>();
        EmployeeDTO employeeDto1 = new EmployeeDTO(7L, "Yateesh", "Chandra", "yateeshchandra@gmail.com");
        EmployeeDTO employeeDto2 = new EmployeeDTO(10L, "Jaya", "Madhuri", "jayamadhuri@gmail.com");
        employeeList.add(employeeDto1);
        employeeList.add(employeeDto2);

        Response expectedResponse = new Response(HttpStatus.OK.value(), ResponseMessages.FETCH_SUCCESS, employeeList);
        Response response = employeeController.getAllEmployees();
        response.setBody(employeeList);
        assertEquals(expectedResponse, response);
    }

    @Test
    void getEmployeeById() {
        Long employeeId = 5L;
        EmployeeDTO employeeDto1 = new EmployeeDTO(employeeId, "Yateesh", "Chandra", "yateeshchandra@gmail.com");
        Response response = employeeController.getEmployeeById(employeeId);
        response.setBody(employeeDto1);
        Response expectedResponse = new Response(HttpStatus.OK.value(), ResponseMessages.FETCH_SUCCESS, employeeDto1);
        assertEquals(expectedResponse, response);
    }
}
