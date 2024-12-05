package com.transporte.transporte.controller;

import com.transporte.transporte.model.Conductor;
import com.transporte.transporte.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/conductor/")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping()
    private ResponseEntity<List<Conductor>> getAllConductores (){
        return ResponseEntity.ok().body(conductorService.findAll());
    }

    @PostMapping
    private ResponseEntity<Conductor> saveConductor (@RequestBody Conductor conductor)  {
        try {
            Conductor conductorGuardada = conductorService.save(conductor);
            return ResponseEntity.created(new URI("/conductor/"+conductorGuardada.getId())).body(conductorGuardada);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}