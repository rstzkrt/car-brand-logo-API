package com.example.carbrandlogoapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200/")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {
    private String brand;
    private String logo;

}