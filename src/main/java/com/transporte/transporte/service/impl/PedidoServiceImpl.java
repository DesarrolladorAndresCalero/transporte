package com.transporte.transporte.service.impl;

import com.transporte.transporte.model.Conductor;
import com.transporte.transporte.model.Pedido;
import com.transporte.transporte.model.Vehiculo;
import com.transporte.transporte.repository.PedidoRepository;
import com.transporte.transporte.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            System.out.println("No se encontraron pedidos.");
        } else {
            System.out.println("pedidos encontrados: " + pedidos);
        }
        return pedidos;
    }

    public List<Pedido> findAllByConductor(int id){
        List<Pedido> pedidosRespuesta = new ArrayList<>();
        List<Pedido> pedidos = pedidoRepositor.findAll();
        for(int i = 0; i < pedidos.size(); i++){
            if(pedidos.get(i).getConductor().getId()==id){
                pedidosRespuesta.add(pedidos.get(i));
           }
        }
        return pedidosRespuesta;
    }

    public void eliminarPedido(int id) {
        Pedido pedido = pedidoRepositor.findById((long) id).orElse(null);
        if (pedido != null) {
            pedidoRepositor.delete(pedido);
        } else {
            throw new RuntimeException("pedido no encontrado");
        }
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