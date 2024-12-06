package com.transporte.transporte.controller;

import com.transporte.transporte.model.Conductor;
import com.transporte.transporte.model.Pedido;
import com.transporte.transporte.model.Vehiculo;
import com.transporte.transporte.repository.ConductorRepository;
import com.transporte.transporte.service.impl.PedidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pedido/")
public class PedidoController {

    @Autowired
    private PedidoServiceImpl pedidoService;
    @Autowired
    private ConductorRepository conductorRepository;

    @GetMapping
    private ResponseEntity<List<Pedido>> getAllPedidos (){
        return ResponseEntity.ok().body(pedidoService.findAll());
    }

    @GetMapping("{id}")
    private ResponseEntity<List<Pedido>> getAllPedidosByConductor (@PathVariable("id") int id){
        return ResponseEntity.ok().body(pedidoService.findAllByConductor(id));
    }

    @DeleteMapping("desasociar/{id}")
    public ResponseEntity<Void> desasociarPedido(@PathVariable("id") int id) {
        try {
            pedidoService.eliminarPedido(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    private ResponseEntity<Pedido> savePedido(@RequestBody Map<String, Object> requestData) {
        try {
            String tipoPedido = (String) requestData.get("tipoPedido");
            String direccion = (String) requestData.get("direccion");
            Integer idConductor = (Integer) requestData.get("idConductor");

            if (idConductor == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Error si no se envía idConductor
            }

            Conductor conductor = conductorRepository.findById(Long.valueOf(idConductor))
                    .orElseThrow(() -> new RuntimeException("Conductor no encontrado"));

            Pedido pedido = new Pedido();
            pedido.setTipoPedido(tipoPedido);
            pedido.setDireccion(direccion);
            pedido.setConductor(conductor);

            Pedido pedidoGuardado = pedidoService.save(pedido);
            return ResponseEntity.created(new URI("/pedido/" + pedidoGuardado.getId())).body(pedidoGuardado);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}