package com.ems.EmployeeManagementProject.controlleradvice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ems.EmployeeManagementProject.exception.AlreadyExistsException;
import com.ems.EmployeeManagementProject.exception.ElementNotExistsException;
import com.ems.EmployeeManagementProject.response.ErrorMessages;
import com.ems.EmployeeManagementProject.response.Response;

@SuppressWarnings("rawtypes")
class GlobalExceptionHandlerTest {

    GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    @Test
    void handleAlreadyExistsException() {
        AlreadyExistsException exception = new AlreadyExistsException(ErrorMessages.EMPLOYEE_EXISTS);
        ResponseEntity<Response> response = globalExceptionHandler.handleAlreadyExistsException(exception);
        Response responseBody = response.getBody();
        assertEquals(responseBody.getCode(), HttpStatus.CONFLICT.value());
        assertEquals(responseBody.getMessage(), exception.getMessage());
    }

    @Test
    void handleElementNotExistsException() {
        ElementNotExistsException exception = new ElementNotExistsException(ErrorMessages.EMPLOYEE_NOTFOUND);
        ResponseEntity<Response> response = globalExceptionHandler.handleElementNotExistsException(exception);
        Response responseBody = response.getBody();
        assertEquals(responseBody.getCode(), HttpStatus.CONFLICT.value());
        assertEquals(responseBody.getMessage(), exception.getMessage());
    }
}
