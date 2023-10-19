package com.ems.EmployeeManagementProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is the AlreadyExistsException.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class AlreadyExistsException extends RuntimeException {

    /**
     * Serial version to avoid unused.
     */
    private static final long serialVersionUID = 1L;

    /**
     * this is the constructor.
     * @param message of String type.
     */
    public AlreadyExistsException(final String message) {
        super(message);
    }
}
