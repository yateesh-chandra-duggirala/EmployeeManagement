package com.ems.EmployeeManagementProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Main method class.
 */
@SpringBootApplication
public class EmployeeManagementProjectApplication {

    /**
     * This is the run method called by Main.
     * @param args arguments.
     */
    private void run(final String[] args) {
        SpringApplication.run(
                EmployeeManagementProjectApplication.class, args);
    }

    /**
     * This is the main method.
     * @param args arguments passed for running main.
     */
    public static void main(final String[] args) {
        new EmployeeManagementProjectApplication().run(args);
    }

}
