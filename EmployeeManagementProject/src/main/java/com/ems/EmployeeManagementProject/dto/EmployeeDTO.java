package com.ems.EmployeeManagementProject.dto;

import java.util.Objects;

import com.ems.EmployeeManagementProject.response.ErrorMessages;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is the Employee DTO class.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    /**
     * This is the Employee ID.
     */
    private Long employeeId;

    /**
     * This is the first Name field.
     */
    @NotBlank(message = ErrorMessages.FIRSTNAME_REQUIRED)
    private String firstName;

    /**
     * This is the last name.
     */
    @NotBlank(message = ErrorMessages.LASTNAME_REQUIRED)
    private String lastName;

    /**
     * This is the email Id.
     */
    @NotBlank(message = ErrorMessages.EMAIL_REQUIRED)
    @Pattern(regexp = "^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$",
            message = ErrorMessages.INVALID_EMAIL)
    private String emailId;

    /**
     * This method is hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(emailId, employeeId, firstName, lastName);
    }

    /**
     * This is the equals method overridden for test cases.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        EmployeeDTO other = (EmployeeDTO) obj;
        return Objects.equals(emailId, other.emailId)
                && Objects.equals(employeeId, other.employeeId)
                && Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName);
    }

}
