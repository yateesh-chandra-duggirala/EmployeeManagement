package com.ems.EmployeeManagementProject.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings({"rawtypes","unchecked"})
class ResponseTest {

    @Test
    void testGetterAndSetter() {
        Response response = new Response();
        response.setCode(400);
        response.setMessage("Response Message");
        response.setBody("Response Body if exists");;

        assertEquals(400, response.getCode());
        assertEquals("Response Message", response.getMessage());
        assertEquals("Response Body if exists",response.getBody());
    }

    @Test
    void testAllArgsWithoutBody() {
        Response response = new Response(400, "Response Message");

        assertEquals(400, response.getCode());
        assertEquals("Response Message", response.getMessage());
    }

    @Test
    void testAllArgsWithBody() {
        Response response = new Response(400, "Response Message", "Response Body if exists");

        assertEquals(400, response.getCode());
        assertEquals("Response Message", response.getMessage());
        assertEquals("Response Body if exists", response.getBody());
    }

    @Test
    void testNoArgs() {
        Response response = new Response();
        assertNotNull(response);
    }
}
