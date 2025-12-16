package com.stilyngnr.salon_belleza.repository;

import com.stilyngnr.salon_belleza.model.Cita;
import com.stilyngnr.salon_belleza.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findByCliente(Usuario cliente);

    @Query("SELECT COUNT(c) FROM Cita c WHERE MONTH(c.fecha) = :mes")
long countCitasMes(@Param("mes") int mes);

@Query("""
SELECT COUNT(c) > 0
FROM Cita c
WHERE c.fecha = :fecha
AND c.estado = 'REGISTRADA'
AND :horaInicio < c.horaFin
AND :horaFin > c.horaInicio
""")
boolean existeSolape(
    @Param("fecha") LocalDate fecha,
    @Param("horaInicio") LocalTime horaInicio,
    @Param("horaFin") LocalTime horaFin
);



}
