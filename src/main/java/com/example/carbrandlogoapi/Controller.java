package com.example.carbrandlogoapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private ModelService modelService;

    @GetMapping("/model")
    public ResponseEntity<List<Model>> getModels() throws IOException {

        return ResponseEntity.ok(modelService.getModels());
    }
}