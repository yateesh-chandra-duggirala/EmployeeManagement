package com.ems.EmployeeManagementProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is the ElementNotExistsException.
 */
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.CONFLICT)
public class ElementNotExistsException extends RuntimeException {

    /**
     * This is the constructor.
     * @param message of String type.
     */
    public ElementNotExistsException(final String message) {
        super(message);
    }
}
