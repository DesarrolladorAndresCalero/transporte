package com.transporte.transporte.service;

import com.transporte.transporte.model.Vehiculo;

import java.util.List;

public interface VehiculoService {
    public List<Vehiculo> findAll();
    public Vehiculo findById(Long id);
    public Vehiculo save(Vehiculo vehiculo);
    public Vehiculo update(Long id,Vehiculo vehiculo);
    public void delete(Long id);
}
