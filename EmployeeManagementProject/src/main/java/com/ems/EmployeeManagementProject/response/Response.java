package com.ems.EmployeeManagementProject.response;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is the Response.
 * @param <T> generic type.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    /**
     * This is the status code field.
     */
    private int code;

    /**
     * This is the message of String type.
     */
    private String message;

    /**
     * This is the Generic Body field.
     */
    private T body;

    /**
     * This is the tow arguments constructor.
     * @param statusCode of integer type.
     * @param printableMessage of String type.
     */
    public Response(final int statusCode, final String printableMessage) {
        this.code = statusCode;
        this.message = printableMessage;
    }

    /**
     * Method for hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(body, code, message);
    }

    /**
     * This is the method to over come assertEquals for the test cases.
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
        @SuppressWarnings("rawtypes")
        Response other = (Response) obj;
        return Objects.equals(body, other.body) && code == other.code
                && Objects.equals(message, other.message);
    }

}
