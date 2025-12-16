package com.stilyngnr.salon_belleza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stilyngnr.salon_belleza.model.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
     List<Servicio> findByActivoTrue();
}
