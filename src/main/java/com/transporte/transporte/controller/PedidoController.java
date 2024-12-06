package com.transporte.transporte.controller;

import com.transporte.transporte.model.Conductor;
import com.transporte.transporte.model.Pedido;
import com.transporte.transporte.service.impl.PedidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido/")
public class PedidoController {

    @Autowired
    private PedidoServiceImpl pedidoService;

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
}