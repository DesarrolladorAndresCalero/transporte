package com.transporte.transporte.service;

import com.transporte.transporte.model.Conductor;

import java.util.List;

public interface ConductorService {
    public List<Conductor> findAll();
    public Conductor findById(Long id);
    public Conductor save(Conductor conductor);
    public Conductor update(Long id,Conductor conductor);
    public void delete(Long id);
}