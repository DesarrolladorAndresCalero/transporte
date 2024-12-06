package com.transporte.transporte.controller;

import com.transporte.transporte.model.Pedido;
import com.transporte.transporte.model.Vehiculo;
import com.transporte.transporte.service.impl.VehiculoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo/")
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

    @DeleteMapping("desasociar/{id}")
    public ResponseEntity<Void> desasociarVehiculo(@PathVariable("id") int id) {
        try {
            vehiculoService.eliminarVehiculo(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}