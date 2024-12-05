package com.transporte.transporte.service.impl;

import com.transporte.transporte.model.Conductor;
import com.transporte.transporte.repository.ConductorRepository;
import com.transporte.transporte.service.ConductorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConductorServiceImpl implements ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public List<Conductor> findAll() {
        List<Conductor> conductores = conductorRepository.findAll();
        if (conductores.isEmpty()) {
            System.out.println("No se encontraron conductores.");
        } else {
            System.out.println("Conductores encontrados: " + conductores);
        }
        return conductores;
    }

    @Override
    public Conductor findById(Long id) {
        System.out.println("Entra al service impl");
        System.out.println("llamado");
        System.out.println(conductorRepository.findById(id).orElse(null));
        return conductorRepository.findById(id).orElse(null);
    }

    @Override
    public Conductor save(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @Override
    public Conductor update(Long id, Conductor conductor) {
        return null;
    }

    @Override
    public void delete(Long id) {
        conductorRepository.deleteById(id);
    }
}