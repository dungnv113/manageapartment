package com.dung.manageapartment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class ManageapartmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageapartmentApplication.class, args);
    }

}
