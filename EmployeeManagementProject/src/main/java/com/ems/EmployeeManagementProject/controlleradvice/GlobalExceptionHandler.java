package com.ems.EmployeeManagementProject.controlleradvice;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ems.EmployeeManagementProject.exception.AlreadyExistsException;
import com.ems.EmployeeManagementProject.exception.ElementNotExistsException;
import com.ems.EmployeeManagementProject.response.Response;

/**
 * This is the Global Exception Handler.
 */
@SuppressWarnings("rawtypes")
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * This is the Exception Handler for BAD_REQUEST.
     *
     * @param exception of MathodNotValidException.
     * @return errorMaps.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final Map<String, Object> handleEmptyInput(
            final MethodArgumentNotValidException exception) {
        Map<String, Object> errorMap = new LinkedHashMap<>();
        errorMap.put("code", HttpStatus.BAD_REQUEST.value());
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }

    /**
     * This is the AlreadyExistsException handler.
     *
     * @param exception of Already Exists Exception.
     * @return the Response Entity.
     */
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<Response> handleAlreadyExistsException(
            final AlreadyExistsException exception) {
        Response response = new Response(HttpStatus.CONFLICT.value(),
                exception.getMessage());
        return new ResponseEntity<Response>(response, HttpStatus.CONFLICT);
    }

    /**
     * This is the Element Not Exists Exception.
     *
     * @param exception of ElementNotExistsException.
     * @return the Response Entity.
     */
    @ExceptionHandler(ElementNotExistsException.class)
    public ResponseEntity<Response> handleElementNotExistsException(
            final ElementNotExistsException exception) {
        Response response = new Response(HttpStatus.CONFLICT.value(),
                exception.getMessage());
        return new ResponseEntity<Response>(response, HttpStatus.CONFLICT);
    }
}
