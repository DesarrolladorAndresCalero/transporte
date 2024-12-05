package com.transporte.transporte.service;

import com.transporte.transporte.model.Pedido;

import java.util.List;

public interface PedidoService {
    public List<Pedido> findAll();
    public Pedido findById(Long id);
    public Pedido save(Pedido pedido);
    public Pedido update(Long id,Pedido pedido);
    public void delete(Long id);
}