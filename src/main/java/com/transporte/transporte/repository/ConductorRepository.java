package com.transporte.transporte.repository;

import com.transporte.transporte.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor,Long> {
}
