package com.metropolitan.controller;

import com.metropolitan.model.Results;
import com.metropolitan.model.dto.ResultsHelper;
import com.metropolitan.service.impl.ResultsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
@CrossOrigin("*")
public class ResultsController {

    @Autowired
    private ResultsServiceImpl resultsServiceImpl;

    @PostMapping("/")
    public ResponseEntity<Results> addResults(@RequestBody ResultsHelper results) {
        return ResponseEntity.ok(resultsServiceImpl.createResults(results));
    }
    @GetMapping("/getAllResults")
    public ResponseEntity<List<Results>> getAllResults(){
        return ResponseEntity.ok(resultsServiceImpl.getAllResults());
    }

}
