package com.transporte.transporte.controller;

import com.transporte.transporte.service.impl.VehiculoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class VehiculoController {

    @Autowired
    private VehiculoServiceImpl vehiculoService;


    @GetMapping()
    private ResponseEntity<?> getAllVehiculos (){
        return ResponseEntity.ok().body(vehiculoService.findAll());
    }

}