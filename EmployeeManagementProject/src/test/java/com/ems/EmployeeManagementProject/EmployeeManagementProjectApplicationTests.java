package com.ems.EmployeeManagementProject;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeManagementProjectApplicationTests {

    @Test
    void testMain() {
        assertDoesNotThrow(() -> EmployeeManagementProjectApplication.main(new String[] {}));
    }

}
