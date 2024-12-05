package com.transporte.transporte.controller;

import com.transporte.transporte.model.Conductor;
import com.transporte.transporte.model.Pedido;
import com.transporte.transporte.service.impl.PedidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido/")
public class PedidoController {

    @Autowired
    private PedidoServiceImpl pedidoService;


    @GetMapping("{id}")
    private ResponseEntity<List<Pedido>> getAllPedidosByConductor (@PathVariable("id") int id){
        return ResponseEntity.ok().body(pedidoService.findAllByConductor(id));
    }
}