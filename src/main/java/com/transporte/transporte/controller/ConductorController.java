package com.transporte.transporte.controller;

import com.transporte.transporte.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/conductor/")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping()
    private ResponseEntity<?> getAllConductores (){
        return ResponseEntity.ok().body(conductorService.findAll());
    }

}