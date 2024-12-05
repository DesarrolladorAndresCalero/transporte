package com.transporte.transporte.service.impl;

import com.transporte.transporte.model.Vehiculo;
import com.transporte.transporte.repository.VehiculoRepository;
import com.transporte.transporte.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public List<Vehiculo> findAll() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo findById(Long id) {
        return vehiculoRepository.findById(id).orElse(null);
    }

    @Override
    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public Vehiculo update(Long id, Vehiculo vehiculo) {
        return null;
    }

    @Override
    public void delete(Long id) {
        vehiculoRepository.deleteById(id);
    }
}