package com.transporte.transporte.controller;

import com.transporte.transporte.model.Conductor;
import com.transporte.transporte.model.Pedido;
import com.transporte.transporte.model.Vehiculo;
import com.transporte.transporte.repository.ConductorRepository;
import com.transporte.transporte.service.impl.VehiculoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vehiculo/")
public class VehiculoController {

    @Autowired
    private VehiculoServiceImpl vehiculoService;

    @Autowired
    private ConductorRepository conductorRepository;

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

    @PostMapping
    private ResponseEntity<Vehiculo> saveVehiculo(@RequestBody Map<String, Object> requestData) {
        try {
            String modelo = (String) requestData.get("modelo");
            String placa = (String) requestData.get("placa");
            String capacidad = (String) requestData.get("capacidad");
            Integer idConductor = (Integer) requestData.get("idConductor");

            if (idConductor == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Error si no se envía idConductor
            }

            Conductor conductor = conductorRepository.findById(Long.valueOf(idConductor))
                    .orElseThrow(() -> new RuntimeException("Conductor no encontrado"));

            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setModelo(modelo);
            vehiculo.setPlaca(placa);
            vehiculo.setCapacidad(capacidad);
            vehiculo.setConductor(conductor);

            Vehiculo vehiculoGuardado = vehiculoService.save(vehiculo);
            return ResponseEntity.created(new URI("/vehiculo/" + vehiculoGuardado.getId())).body(vehiculoGuardado);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}