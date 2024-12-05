package com.transporte.transporte.service.impl;

import com.transporte.transporte.model.Conductor;
import com.transporte.transporte.model.Pedido;
import com.transporte.transporte.repository.PedidoRepository;
import com.transporte.transporte.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepositor;

    @Override
    public List<Pedido> findAll() {
        List<Pedido> pedidos = pedidoRepositor.findAll();
        if (pedidos.isEmpty()) {
            System.out.println("No se encontraron conductores.");
        } else {
            System.out.println("Conductores encontrados: " + pedidos);
        }
        return pedidos;
    }

    @Override
    public Pedido findById(Long id) {
        return pedidoRepositor.findById(id).orElse(null);
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepositor.save(pedido);
    }

    @Override
    public Pedido update(Long id, Pedido pedido) {
        return null;
    }

    @Override
    public void delete(Long id) {
        pedidoRepositor.deleteById(id);
    }
}