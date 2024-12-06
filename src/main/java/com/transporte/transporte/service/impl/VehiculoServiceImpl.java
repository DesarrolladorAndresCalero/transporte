package com.transporte.transporte.service.impl;

import com.transporte.transporte.model.Conductor;
import com.transporte.transporte.model.Vehiculo;
import com.transporte.transporte.repository.ConductorRepository;
import com.transporte.transporte.repository.VehiculoRepository;
import com.transporte.transporte.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public List<Vehiculo> findAll() {
        List<Vehiculo> vehiculo = vehiculoRepository.findAll();
        if (vehiculo.isEmpty()) {
            System.out.println("No se encontraron vehiculo.");
        } else {
            System.out.println("vehiculo encontrados: " + vehiculo);
        }
        return vehiculo;
    }

    public List<Vehiculo> findAllByConductor(int id){
        List<Vehiculo> vehiculoRespuesta = new ArrayList<>();
        List<Vehiculo> vehiculo = vehiculoRepository.findAll();
        for(int i = 0; i < vehiculo.size(); i++){
            if(vehiculo.get(i).getConductor().getId()==id){
                vehiculoRespuesta.add(vehiculo.get(i));
            }
        }
        return vehiculoRespuesta;
    }

    public void eliminarVehiculo(int id) {
        Vehiculo vehiculo = vehiculoRepository.findById((long) id).orElse(null);
        if (vehiculo != null) {
            vehiculoRepository.delete(vehiculo);
        } else {
            throw new RuntimeException("Vehículo no encontrado");
        }
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