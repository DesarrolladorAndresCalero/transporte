package com.transporte.transporte.controller;

import com.transporte.transporte.model.Pedido;
import com.transporte.transporte.model.Vehiculo;
import com.transporte.transporte.service.impl.VehiculoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class VehiculoController {

    @Autowired
    private VehiculoServiceImpl vehiculoService;

    @GetMapping
    private ResponseEntity<List<Vehiculo>> getAll (){
        return ResponseEntity.ok().body(vehiculoService.findAll());
    }

    @GetMapping("{id}")
    private ResponseEntity<List<Vehiculo>> getAllPedidosByConductor (@PathVariable("id") int id){
        return ResponseEntity.ok().body(vehiculoService.findAllByConductor(id));
    }
}