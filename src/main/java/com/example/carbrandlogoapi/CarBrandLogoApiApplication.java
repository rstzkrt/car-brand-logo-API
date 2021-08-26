package com.example.carbrandlogoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200/")
@SpringBootApplication
public class CarBrandLogoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarBrandLogoApiApplication.class, args);
    }
}
