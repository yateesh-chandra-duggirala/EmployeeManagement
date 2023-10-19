package com.ems.EmployeeManagementProject.response;

/**
 * Error Messages class.
 */
public final class ErrorMessages {

    /**
     * No Arguments constructor.
     */
    private ErrorMessages() {
    }

    /**
     * This constant tells first name is required.
     */
    public static final String FIRSTNAME_REQUIRED = "First name is required";

    /**
     * This constant tells last name is required.
     */
    public static final String LASTNAME_REQUIRED = "Last name is required";

    /**
     * This constant tells email is required.
     */
    public static final String EMAIL_REQUIRED = "Email is required";

    /**
     * This constant tells Employee exists.
     */
    public static final String EMPLOYEE_EXISTS = "Employee with this email"
            + " already exists";

    /**
     * This constant tells Email is invalid.
     */
    public static final String INVALID_EMAIL = "Email is invalid";

    /**
     * This constant tells employee not found.
     */
    public static final String EMPLOYEE_NOTFOUND = "Employee not found with"
            + " Id :";
}
