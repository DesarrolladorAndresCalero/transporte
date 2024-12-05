package com.transporte.transporte.controller;

import com.transporte.transporte.model.Conductor;
import com.transporte.transporte.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/conductor/")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping
    private ResponseEntity<List<Conductor>> getAllConductores (){
        List<Conductor> conductores = new ArrayList<Conductor>();
        Conductor conductor = new Conductor();
        conductores = conductorService.findAll();
        System.out.println(conductores.get(0));
        return ResponseEntity.ok(conductorService.findAll());
    }
}
